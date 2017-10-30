package com.cmcc.ms.controller;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.utils.HttpHelper;
import com.cmcc.ms.common.utils.JSONUtils;
import com.cmcc.ms.common.utils.MD5;
import com.cmcc.ms.common.utils.PropertiesUtils;
import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.entity.system.Menu;
import com.cmcc.ms.entity.system.Node;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.entity.system.SysUsersManual;
import com.cmcc.ms.entity.system.TreeNode;
import com.cmcc.ms.entity.system.TreeSupport;
import com.cmcc.ms.exception.AuthException;
import com.cmcc.ms.mapper.SysUsersMapperManual;
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.system.SysUsersService;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;

/**
 * 用户登录模块controller.
 *
 * @author ldy
 */
@Controller
public class LoginController extends BaseController {

    /** The sys users service. */
    /*
     * 注入
     */
    @Autowired
    private SysUsersService sysUsersService;

    /** The sys users mapper manual. */
    @Autowired
    private SysUsersMapperManual sysUsersMapperManual;

    /** The operate log service impl. */
    @Autowired
    private OperateLogServiceImpl operateLogServiceImpl;

    /** The redis client template. */
    @Autowired
    public RedisClientTemplate redisClientTemplate;

    /** The s ERVERMENUID. */
    private String sERVERMENUID = null;

    //private Logger log = LoggerFactory.getLogger(this.getClass());

    /** The sys users mapper manual cmcciw. */
    private SysUsersMapperManual sysUsersMapperManualCmcciw;

    /** The session time. */
    private int sessionTime = 60;

    /**
     * Sets the sys users mapper manual cmcciw.
     *
     * @param session the new sys users mapper manual cmcciw
     */
    @Resource(name = "sqlSessionCmcciw")
    public void setSysUsersMapperManualCmcciw(SqlSession session) {
        this.sysUsersMapperManualCmcciw = session.getMapper(SysUsersMapperManual.class);
    }

    /**
     * 登录.
     *
     * @param request the request
     * @param response the response
     * @param userName the user name
     * @param userPassword the user password
     * @param code the code
     * @param password the password
     * @param model the model
     * @return the JSON object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("userName") String userName,
                              @RequestParam("userPassword") String userPassword,
                              @RequestParam("code") String code,
                              @RequestParam("password") String password, Model model) {
        JSONObject main = new JSONObject();
        //解决安全测试sessionid问题（解决绕过会话管理测试）
        reGenerateSessionId(request);
        // 首先判断 该用户是否存在数据库,如果不存在直接登录失败
        String validate = validate(request, response, userName, userPassword, code, password, main);
        if ("0".equals(validate)) {
            JSONObject tree = main(request, response);
            main.put("tree", tree);
        }
        main.put("code", validate);
        return main;

    }

    /**
     * 跳转登录主页.
     *
     * @param request the request
     * @param response the response
     * @return the JSON object
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject main(HttpServletRequest request, HttpServletResponse response) {
        Object userid = SessionUtils.getAttribute(request, "userid");
        TreeNode tree = createTree(request, userid.toString());
        JSONObject jsonObject = JSONUtils.toJSONObject(tree);
        return jsonObject;
    }

    /**
     * 登录校验.
     *
     * @param request the request
     * @param userName the user name
     * @param userPassword the user password
     * @param code the code
     * @param password the password
     * @param main the main
     * @return the string
     */
    private String validate(HttpServletRequest request, HttpServletResponse response,
                            String userName, String userPassword, String code, String password,
                            JSONObject main) {
        if (StringUtils.isEmpty(userName)) {
            main.put("error", "用户名不能为空！");
            return "1";
        } else if (StringUtils.isEmpty(userPassword)) {
            main.put("error", "密码不能为空！");
            return "1";
        } else if (StringUtils.isEmpty(code)
                && "1".equals(PropertiesUtils.findPropertiesKey("VERCODE",
                        "/resetPwdConfig.properties"))) {
            main.put("error", "验证码不能为空！");
            return "2";
        }
        try {
            String verifyCode = SessionUtils.getAttribute(request, "verifyCode").toString();
            if (!verifyCode.equalsIgnoreCase(code)
                    && "1".equals(PropertiesUtils.findPropertiesKey("VERCODE",
                            "/resetPwdConfig.properties"))) {
                main.put("error", "验证码错误！");
                return "2";
            }
        } catch (NullPointerException ex) {
            main.put("error", "验证码错误！");
            return "2";
        }
        SysUsersManual sysUsers = sysUsersService.selectByUserName(userName);
        if (sysUsers == null) {
            main.put("error", "用户名不存在！");
            return "1";
        } else {
            if ("hechuang".equals(sysUsers.getUserDesc())) {
                String secretKey = PropertiesUtils.findPropertiesKey("appSecretKey",
                        "/interfaceInfo.properties");
                String iwPwd = MD5.calcMD5(password + secretKey);
                String dataPwd = sysUsersMapperManualCmcciw.selectCmcciwByUserName(userName);
                if (dataPwd == null) {
                    main.put("error", "用户名不存在！");
                    return "1";
                } else {
                    if (!dataPwd.equals(iwPwd)) {
                        main.put("error", "密码错误！");
                        return "1";
                    }
                }
            } else {
                String calcMD5 = sysUsers.getUserPassword();
                String calcMD52 = MD5.calcMD5(userPassword.trim() + userName.trim());
                if (calcMD5 != null && !calcMD5.equals(calcMD52)) {
                    main.put("error", "密码错误！");
                    return "1";
                }
                if ("0".equals(sysUsers.getState())) {
                    main.put("error", "账户状态异常，请与管理员联系！");
                    return "3";
                }
            }
            main.put("roleId", sysUsers.getRoleId());
            main.put("userName", sysUsers.getUserName());
            doLoginAttr(request, response, sysUsers);
            return "0";
        }
    }

    /**
     * Do login attr.
     *
     * @param request the request
     * @param sysUsers the sys users
     */
    private void doLoginAttr(HttpServletRequest request, HttpServletResponse response,
                             SysUsersManual sysUsers) {
        Boolean sismember = redisClientTemplate.sismember("loginUserId", sysUsers.getUserId() + "");
        if (sismember != null && sismember) {
            //获取已登录用户sessionID
            String sessionId = redisClientTemplate.get(sysUsers.getUserName());
            if (sessionId != null) {
                byte[] session = redisClientTemplate.get(sessionId.getBytes());
                if (null != session) {
                    redisClientTemplate.set((sessionId + "NOAUTO").getBytes(), "NOAUTO".getBytes());
                    redisClientTemplate.expire((sessionId + "NOAUTO"), sessionTime);
                }
            }
            redisClientTemplate.set(sysUsers.getUserName(), request.getSession().getId());
        } else {
            redisClientTemplate.set(sysUsers.getUserName(), request.getSession().getId());
        }
        sysUsers.setLastwrotime(new Date());
        sysUsers.setWrongcount(sysUsers.getWrongcount() + 1);
        sysUsersMapperManual.updateLastWroTimeByUser(sysUsers);
        SessionUtils.setAttribute(request, "userNameSession", sysUsers.getUserName());
        SessionUtils.setAttribute(request, "userName", sysUsers.getUserName());
        SessionUtils.setAttribute(request, "userid", sysUsers.getUserId());
        SessionUtils.setAttribute(request, "userRelname", sysUsers.getUserRelname());
        SessionUtils.setAttribute(request, "roleid", sysUsers.getRoleId());

        operateLogServiceImpl.saveBroInfo(request);

        try {
            String url = PropertiesUtils.findPropertiesKey("URL", "/resetPwdConfig.properties")
                    + "resourceTestQuery";
            String invokeGet = HttpHelper.invokeGet(url, new LinkedHashMap<String, String>(),
                    PropertiesUtils.findPropertiesKey("ACCPTTYPE", "/resetPwdConfig.properties"));
            System.out.println("测试查询：" + invokeGet);
        } catch (Exception e) {
            System.out.print("测试查询出错：" + e.getMessage());
        }
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName") + "已登录");
        operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
        operateLogServiceImpl.saveUserOperation(operateLog, request);
    }

    /**
     * 注销.
     *
     * @param request the request
     * @throws AuthException the auth exception
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public void loginOut(HttpServletRequest request) throws AuthException {
        //获取已登录用户sessionID
        String userName = (String) SessionUtils.getAttribute(request, "userName");
        if (userName != null) {
            String sessionId = redisClientTemplate.get(userName);
            if (sessionId != null && sessionId.equals(request.getSession().getId())) {
                request.getSession().removeAttribute("userNameSession");
            } else if (sessionId != null && !sessionId.equals(request.getSession().getId())) {
                remOldSessionJudge(request);
            }
        }
    }

    /**
     * 删除旧Session.
     *
     * @param request the request
     * @throws AuthException the auth exception
     */
    private void remOldSessionJudge(HttpServletRequest request) throws AuthException {
        byte[] redisFlag = redisClientTemplate.get((request.getSession().getId() + "NOAUTO")
                .getBytes());
        if (redisFlag != null && new String(redisFlag).equals("NOAUTO")) {
            redisClientTemplate.del((request.getSession().getId() + "NOAUTO").getBytes());
            redisClientTemplate.del((request.getSession().getId()).getBytes());
            throw new AuthException();
        }
    }

    /**
     * 根据菜单生成树.
     *
     * @param request the request
     * @param userid the userid
     * @return the tree node
     */
    public TreeNode createTree(HttpServletRequest request, String userid) {
        SysUsersManual selectByPrimaryKey = sysUsersService.selectByPrimaryKey(Integer
                .valueOf((String) userid));
        List<SysMenus> menusTree = selectByPrimaryKey.getSysRolesManual().getSysMenus();
        SessionUtils.setAttribute(request, SessionUtils.getAttribute(request, "roleid")
                + "province", menusTree);
        // 不显示业务数据树结构
        sERVERMENUID = PropertiesUtils.findPropertiesKey("SERVERMENUID",
                "/resetPwdConfig.properties");
        Integer menuIdSer = new Integer(sERVERMENUID);
        for (Iterator<SysMenus> iterator = menusTree.iterator(); iterator.hasNext();) {
            SysMenus sysMenus = (SysMenus) iterator.next();
            if (sysMenus.getType() < menuIdSer) {
                iterator.remove();
            }
        }
        Set<SysMenus> treeMenus = new TreeSet<SysMenus>(menusTree);
        // 生成树节点
        List<Node> nodeItems = new ArrayList<Node>();
        Iterator<SysMenus> it = treeMenus.iterator();
        while (it.hasNext()) {
            SysMenus sysMenus = (SysMenus) it.next();
            if (sysMenus.getDepth() >= 3) {
                continue;
            }
            Menu menu = new Menu();
            menu.setId((sysMenus.getMenuId().longValue()));
            menu.setName(sysMenus.getMenuName());
            menu.setParentId(sysMenus.getParentId());
            menu.setResource("/" + sysMenus.getUrl());
            nodeItems.add(menu);
        }
        if (nodeItems.size() > 0) {
            // 生成树
            TreeSupport treeSupport = new TreeSupport();
            TreeNode treeNode = treeSupport.createTreeNode(nodeItems);
            return treeNode;
        } else {
            return null;
        }
    }

    /**
     * 前台用户登录.
     *
     * @param request the request
     * @param response the response
     */
    @RequestMapping(value = "/loginForHC")
    public void loginForHC(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("phone");
        SysUsersManual sysUsers = sysUsersService.selectByUserName(userName);
        if (null != sysUsers && null != request.getParameter("token")) {
            JSONObject tokenCheck = tokenCheck(request.getParameter("token"));
            if (tokenCheck != null && "200".equals(tokenCheck.get("resultCode"))) {
                doLoginAttr(request, response, sysUsers);
            }
        }
        try {
            response.sendRedirect("main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  
     * 发送 get请求 .
     *
     * @param token the token
     * @return the JSON object
     */
    public JSONObject tokenCheck(String token) {
        JSONObject resultJsonObject = null;
        //构造HttpClient的实例  
        CloseableHttpClient httpclient = createSSLClientDefault();
        // 创建httpget.    
        HttpGet httpget = new HttpGet(PropertiesUtils.findPropertiesKey("TOKENURL",
                "/resetPwdConfig.properties") + token);
        try {
            // 执行get请求.    
            HttpResponse httpResponse = httpclient.execute(httpget);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
            } else {
                // 读取内容
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    //按指定编码转换结果实体为String类型
                    String result = EntityUtils.toString(entity, "UTF-8");
                    resultJsonObject = JSONObject.fromObject(result);
                }
                EntityUtils.consume(entity);
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();// 发生网络异常
        } finally {
            httpget.releaseConnection();// 释放连接
        }
        return resultJsonObject;
    }

    /**
     * createSSLClientDefault.
     *
     * @return the closeable http client
     */
    public CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().useProtocol("TLSv1.2")
                    .loadTrustMaterial(null, new TrustStrategy() {
                        //信任所有
                        public boolean isTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                    new TrustAnyHostnameVerifier());
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    /**
     * TrustAnyHostnameVerifier.
     *
     * @author Administrator
     */
    private static class TrustAnyHostnameVerifier implements HostnameVerifier {

        /**
         * verify.
         *
         * @param hostname the hostname
         * @param session the session
         * @return true, if successful
         */
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * 登录时重新生成sessionId，解解决绕过会话管理测试.
     *
     * @param request the request
     */
    private static void reGenerateSessionId(HttpServletRequest request) {

        HttpSession session = request.getSession();

        //首先将原session中的数据转移至一临时map中  
        Map<String, Object> tempMap = new HashMap<String, Object>();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            String sessionName = sessionNames.nextElement();
            tempMap.put(sessionName, session.getAttribute(sessionName));
        }

        //注销原session，为的是重置sessionId  
        session.invalidate();

        //将临时map中的数据转移至新session  
        session = request.getSession();
        for (Map.Entry<String, Object> entry : tempMap.entrySet()) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }
    }
}
