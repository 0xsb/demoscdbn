package com.cmcc.ms.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.enums.EnumUserState;
import com.cmcc.ms.common.utils.JSONUtils;
import com.cmcc.ms.common.utils.MD5;
import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.common.utils.StringUtil;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.entity.system.SysRolesManual;
import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersManual;
import com.cmcc.ms.mapper.SysUsersMapper;
import com.cmcc.ms.mapper.SysUsersMapperManual;
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.system.SysRolesService;
import com.cmcc.ms.service.system.SysUsersService;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 用户模块controller.
 *
 * @author ldy
 */
@Controller
@RequestMapping("/user")
public class UsersController extends BaseController {

    /** The sys roles service. */
    /*
     * 注入
     */
    @Autowired
    private SysRolesService sysRolesService;

    /** The sys users service. */
    @Autowired
    private SysUsersService sysUsersService;

    /** The sys users dao. */
    @Autowired
    private SysUsersMapper sysUsersDao;

    /** The sys users manual dao. */
    @Autowired
    private SysUsersMapperManual sysUsersManualDao;

    /** The operate log service impl. */
    @Autowired
    private OperateLogServiceImpl operateLogServiceImpl;

    /** The redis client template. */
    @Autowired
    public RedisClientTemplate redisClientTemplate;

    /**
     * 跳转用户详情.
     *
     * @param userId the user id
     * @param model the model
     * @param request the request
     * @return the JSON object
     */
    @RequestMapping(value = "/userTail/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject tail(@PathVariable String userId, Model model, HttpServletRequest request) {
        JSONObject res = new JSONObject();
        SysUsersManual sysUsers = sysUsersService.selectByPrimaryKey(Integer.valueOf(userId));
        SysRolesManual sysRoles = sysRolesService.selectByPrimaryKey(sysUsers.getRoleId());
        List<SysRolesManual> list = getRolesList(request);
        res.put("user", JSONObject.fromObject(sysUsers));
        res.put("role", JSONObject.fromObject(sysRoles));
        res.put("roles", JSONUtils.toJSONString(list));
        return res;
    }

    /**
     * 跳转用户编辑.
     *
     * @param userId the user id
     * @param model the model
     * @param request the request
     * @return the JSON object
     */
    @RequestMapping(value = "/userEdit/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject edit(@PathVariable String userId, Model model, HttpServletRequest request) {
        JSONObject res = new JSONObject();
        SysUsersManual sysUsers = sysUsersService.selectByPrimaryKey(Integer.valueOf(userId));
        sysUsers.setUserPassword("A12345678");
        SysRolesManual sysRoles = sysRolesService.selectByPrimaryKey(sysUsers.getRoleId());
        List<SysRolesManual> list = getRolesList(request);
        res.put("user", JSONObject.fromObject(sysUsers));
        res.put("role", JSONObject.fromObject(sysRoles));
        res.put("roles", JSONUtils.toJSONString(list));
        return res;
    }

    /**
     * 用户列表.
     *
     * @param request the request
     * @param userName the user name
     * @param pageSize the page size
     * @param pageNum the page num
     * @return the JSON object
     */
    @RequestMapping(value = "/usersShow", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject query(HttpServletRequest request,
                            @RequestParam(value = "userName", required = false) String userName,
                            @RequestParam(value = "pageSize", required = false) String pageSize,
                            @RequestParam(value = "pageNum", required = false) String pageNum) {
        if (!StringUtil.isNotNUll(pageSize)) {
            pageSize = "50";
        }
        if (!StringUtil.isNotNUll(pageNum)) {
            pageNum = "1";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);
        if (StringUtil.isNotNUll(userName)) {
            map.put("userName", userName);
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("userName", userName);
        List<SysUsersManual> usersList = sysUsersService.getSysUsersList(hashMap);
        List<SysUsersManual> userList = sysUsersService.getSysUsersList(map);
        for (SysUsersManual user : userList) {
            user.setState(EnumUserState.indexByCode(Integer.valueOf(user.getState())).getValue());
            if (redisClientTemplate.exists("loginUserId")
                    && redisClientTemplate.sismember("loginUserId", user.getUserId() + "")) {
                user.setLoginStatus(true);
            }
        }
        
        List<SysRolesManual> roleList = getRolesList(request);
        JSONObject res = new JSONObject();
        res.put("userNameRel", userName);
        res.put("totalSize", usersList.size());
        res.put("pageTotal", (usersList.size() + new Integer(pageSize) - 1) / new Integer(pageSize));
        res.put("pageSize", pageSize);
        res.put("pageNum", pageNum);
        res.put("roles", JSONUtils.toJSONString(roleList));
        res.put("users", JSONUtils.toJSONString(userList));
        return res;
    }

    /**
     * 用户修改.
     *
     * @param request the request
     * @param model the model
     * @param userId the user id
     * @param userRelname the user relname
     * @param userPassword the user password
     * @param tokenp the tokenp
     * @param phone the phone
     * @param email the email
     * @param roleId the role id
     * @param state the state
     * @param company the company
     * @return the string
     */
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(HttpServletRequest request,
                         Model model,
                         @RequestParam(value = "userId", required = true) Integer userId,
                         @RequestParam(value = "userRelname", required = false) String userRelname,
                         @RequestParam(value = "userPassword", required = false) String userPassword,
                         @RequestParam(value = "tokenp", required = false) String tokenp,
                         @RequestParam(value = "phone", required = false) String phone,
                         @RequestParam(value = "email", required = false) String email,
                         @RequestParam(value = "roleId", required = false) Integer roleId,
                         @RequestParam(value = "state", required = false) String state,
                         @RequestParam(value = "company", required = false) String company) {
        String res = "";
        SysUsersManual sysUsers = sysUsersService.selectByPrimaryKey(Integer.valueOf(userId));
        if (sysUsers == null) {
            return "error";
        }
        sysUsers.setLastwrotime(new Date());
        sysUsers.setUserRelname(userRelname);
        sysUsers.setPhone(phone);
        //        if ((checkInput(tokenp)
        //                && StringUtil.maxsubstringLength(tokenp, sysUsers.getUserName()) < 4 && StringUtil
        //                .maxsubstringLength(tokenp, sysUsers.getPhone()) < 4)) {
        //        }
        if (!(sysUsers.getUserPassword()).equals(userPassword)) {
            sysUsers.setUserPassword(MD5.calcMD5(MD5.calcMD5(userPassword.trim())
                    + sysUsers.getUserName().trim()));
        }
        if (StringUtil.isNotNUll(email)) {
            sysUsers.setEmail(email);
        }
        if (roleId != 0) {
            sysUsers.setRoleId(roleId);
        }
        if (StringUtil.isNotNUll(state) && ("0".equals(state.trim()) || "1".equals(state.trim()))) {
            sysUsers.setState(state);
        }
        sysUsers.setCompany(company);
        SysUsers dest = sysUsersDao.selectByPrimaryKey(userId);
        try {
            BeanUtils.copyProperties(dest, sysUsers);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Integer result = sysUsersService.updateByPrimaryKeySelective(dest);
        if (result.intValue() == 1) {
            OperateLog operateLog = new OperateLog();
            operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName") + "修改用户 "
                    + userRelname);
            operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
            operateLogServiceImpl.saveUserOperation(operateLog, request);
            res = "success";
        } else {
            res = "error";
        }
        return res;
    }

    /**
     * 用户名校验.
     *
     * @param model the model
     * @param userName the user name
     * @return the map
     */
    @RequestMapping(value = "/users/checkName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(Model model,
                                      @RequestParam(value = "userName", required = false) String userName) {
        SysUsersManual sysUsers = sysUsersService.selectByUserName(userName);
        Map<String, Object> map = new HashMap<String, Object>();
        if (sysUsers != null) {
            map.put("msg", "fail");
        } else {
            map.put("msg", "success");
        }
        return map;
    }

    /**
     * 校验密码（预留）.
     *
     * @param model the model
     * @param userId the user id
     * @param oldPassword the old password
     * @return the map
     */
    @RequestMapping(value = "/users/checkPass", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatepd(Model model,
                                        @RequestParam(value = "userId", required = false) Integer userId,
                                        @RequestParam(value = "oldPassword", required = false) String oldPassword) {
        SysUsersManual sysUsers = sysUsersService.selectByPrimaryKey(userId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (sysUsers != null && sysUsers.getUserPassword() != null
                && sysUsers.getUserPassword().equalsIgnoreCase(MD5.calcMD5(oldPassword))) {
            map.put("msg", "success");
        } else {
            map.put("msg", "error");
        }
        return map;
    }

    /**
     * 跳转用户添加.
     *
     * @param model the model
     * @param request the request
     * @return the JSON object
     */
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject add(Model model, HttpServletRequest request) {
        JSONObject res = new JSONObject();
        List<SysRolesManual> list = getRolesList(request);
        res.put("roles", JSONUtils.toJSONString(list));
        return res;
    }

    /**
     * 用户添加.
     *
     * @param request the request
     * @param model the model
     * @param userName the user name
     * @param userRelname the user relname
     * @param userPassword the user password
     * @param phone the phone
     * @param email the email
     * @param company the company
     * @param state the state
     * @param roleId the role id
     * @param userDesc the user desc
     * @return the string
     */
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request, Model model,
                      @RequestParam(value = "userName", required = false) String userName,
                      @RequestParam(value = "userRelname", required = false) String userRelname,
                      @RequestParam(value = "userPassword", required = false) String userPassword,
                      @RequestParam(value = "phone", required = false) String phone,
                      @RequestParam(value = "email", required = false) String email,
                      @RequestParam(value = "company", required = false) String company,
                      @RequestParam(value = "state", required = false) String state,
                      @RequestParam(value = "roleId", required = false) Integer roleId,
                      @RequestParam(value = "userDesc", required = false) String userDesc) {
        SysUsers sysUsers = new SysUsers();
        String res = "";
        if (null == roleId
                || !StringUtil.isNotNUll(userName, userRelname, userPassword, email, state)) {
            res = "noRole";
        } else {
            SysUsersManual user = sysUsersService.selectByUserName(userName);
            if (user != null) {
                res = "same";
            } else {
                sysUsers.setRoleId(roleId);
                sysUsers.setUserName(userName);
                sysUsers.setUserRelname(userRelname);
                sysUsers.setUserPassword(MD5.calcMD5(MD5.calcMD5(userPassword.trim())
                        + userName.trim()));
                sysUsers.setPhone(phone);
                sysUsers.setEmail(email);
                sysUsers.setCompany(company);
                sysUsers.setState(state);
                sysUsers.setUserDesc(userDesc);
                sysUsers.setWrongcount(0);
                sysUsers.setCreateDate(new Date());
                sysUsers.setLastwrotime(new Date());
                Integer insert = sysUsersService.insert(sysUsers);
                if (insert == 1) {
                    OperateLog operateLog = new OperateLog();
                    operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName")
                            + "添加用户 " + userRelname);
                    operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
                    operateLogServiceImpl.saveUserOperation(operateLog, request);
                    res = "success";
                } else {
                    res = "error";
                }
            }
        }
        return res;
    }

    /**
     * 用户禁用/启用.
     *
     * @param request the request
     * @param model the model
     * @param userIds the user ids
     * @param flag the flag
     * @return the map
     */
    @RequestMapping(value = "/users/del", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> del(HttpServletRequest request,
                                   Model model,
                                   @RequestParam(value = "userIds[]", required = true) String[] userIds,
                                   @RequestParam(value = "flag", required = true) String flag) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userIds.length > 0) {
            Integer result = 0;
            if (flag != null && "on".equals(flag.trim())) {
                result = sysUsersManualDao.updateStateByUserIds(userIds);
            } else {
                result = sysUsersService.deleteByUserIds(userIds);
            }
            String users = "";
            for (int i = 0; i < userIds.length; i++) {
                users += userIds[i] + " ";
            }
            if (result.intValue() >= 1) {
                OperateLog operateLog = new OperateLog();
                operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName")
                        + "禁用ID为：" + users + "的用户 ");
                operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
                operateLogServiceImpl.saveUserOperation(operateLog, request);
                map.put("msg", "success");
            } else {
                map.put("msg", "fail");
            }
        } else {
            map.put("msg", "error");
        }
        return map;

    }

    /**
     * 用户赋权.
     *
     * @param request the request
     * @param model the model
     * @param userIds the user ids
     * @param subGroup the sub group
     * @return the map
     */
    @RequestMapping(value = "/users/usersGetRight", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> usersGetRight(HttpServletRequest request,
                                             Model model,
                                             @RequestParam(value = "userIds[]", required = true) String[] userIds,
                                             @RequestParam(value = "subGroup", required = true) String subGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userIds.length > 0) {
            Integer result = sysUsersService.usersGetRightByUserIds(userIds, subGroup);
            if (result.intValue() >= 1) {
                OperateLog operateLog = new OperateLog();
                String userIdStr = "";
                for (String s : userIds) {
                    userIdStr += " " + s.toString();
                }
                operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName")
                        + "对ID为[" + userIdStr + "]的用户赋权 ");
                operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
                operateLogServiceImpl.saveUserOperation(operateLog, request);
                map.put("msg", "success");
            } else {
                map.put("msg", "fail");
            }
        } else {
            map.put("msg", "error");
        }
        return map;

    }

    /**
     * 预留正则匹配.
     *
     * @param str the str
     * @return true, if successful
     */
    public boolean checkInput(String str) {
        if (str.length() < 8) {
            return false;
        }
        int num = 0;
        num = Pattern.compile("\\d").matcher(str).find() ? num + 1 : num;
        num = Pattern.compile("[a-z]").matcher(str).find() ? num + 1 : num;
        num = Pattern.compile("[A-Z]").matcher(str).find() ? num + 1 : num;
        //num = Pattern.compile("[-.!@#$%^&*()+?><]").matcher(str).find() ? num + 1 : num;

        return num >= 2;
    }

    /**
     * 获取角色.
     *
     * @param request the request
     * @return the roles list
     */
    public List<SysRolesManual> getRolesList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        return sysRolesService.getSysRolesList(map, new PageBounds());
    }
}
