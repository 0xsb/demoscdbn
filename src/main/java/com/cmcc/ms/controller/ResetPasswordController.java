package com.cmcc.ms.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.utils.PropertiesUtils;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersExample;
import com.cmcc.ms.entity.system.SysUsersExample.Criteria;
import com.cmcc.ms.entity.system.SysUsersManual;
import com.cmcc.ms.mapper.SysUsersMapper;
import com.cmcc.ms.service.system.SysUsersService;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;
import com.cmcc.ms.service.system.impl.ResetPasswordServiceImp;

/**
 * 功能：重设密码.
 */
@Controller
@RequestMapping(value = "/getpassword")
@Scope(value = "prototype")
public class ResetPasswordController extends BaseController {

    /** The reset service. */
    @Autowired
    private ResetPasswordServiceImp resetService;

    /** The sys users service. */
    @Autowired
    private SysUsersService sysUsersService;

    /** The sys users dao. */
    @Autowired
    private SysUsersMapper sysUsersDao;

    /** The operate log service impl. */
    @Autowired
    private OperateLogServiceImpl operateLogServiceImpl;

    /** The port. */
    String port = PropertiesUtils.findPropertiesKey("PORT", "/resetPwdConfig.properties");
    /** The t OKENTIME. */
    private Integer tOKENTIME = 24 * 3600000;
   
    /**
     * Forgetpwd.
     *
     * @return the string
     */
    @RequestMapping(value = "/forgetpwd.html")
    public String forgetpwd() {
        return "account/forgetpassword";
    }

    /**
     *  
     * 使用simple mail生成连接并发送到邮箱.
     *
     * @param request the request
     * @param userName the user name
     * @param email the email
     * @return String json
     */
    @RequestMapping(value = "/presentreset.html")
    @ResponseBody
    public String generateResetURI(HttpServletRequest request,
                                   @RequestParam(value = "userName", required = true) String userName,
                                   @RequestParam(value = "email", required = true) String email) {
        tOKENTIME = new Integer(PropertiesUtils.findPropertiesKey("TOKENTIME",
                "/resetPwdConfig.properties").trim()) * 3600000;
        String msg = "";
        SysUsersExample example = new SysUsersExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName.trim());
        criteria.andEmailEqualTo(email.trim());
        List<SysUsers> list = sysUsersDao.selectByExample(example);
        if (list.size() == 0) {
            msg = "{\"msg\":\"fail\"}";
        } else {
            Integer userId = list.get(0).getUserId();
            // 项目名：
            String path = request.getContextPath();
            // WEB路径：
            if (null != userId) {
                String res = null;
                SysUsersManual user = sysUsersService.selectByPrimaryKey(new Integer(userId));
                String token = user.getToken();
                
                if (token != null && !"".equals(token.trim())) {
                    String[] strings = token.split("@");
                    if (System.currentTimeMillis() + tOKENTIME+(-0.5)*3600000 < new Long(strings[1])) {
                        msg = "{\"msg\":\"retry\"}";
                        return msg;
                    }
                }
                try {
                    res = resetService.addValidateSendEmail(path, userId + "");
                } catch (MessagingException e) {
                    e.printStackTrace();
                    msg = "{\"msg\":\"error\"}";
                }
                if ("success".equals(res)) {
                    msg = "{\"msg\":\"success\"}";
                } else {
                    msg = "{\"msg\":\"error\"}";
                }
            } else {
                msg = "{\"msg\":\"error\"}";
            }
        }
        return msg;
    }

    /**
     * 跳转到重设密码页面，同时将用户修改依据凭证放入session中，或返回视图再传递回来.
     *
     * @param userId            用户id
     * @param uuid            修改验证id
     * @param request the request
     * @param model the model
     * @return 重设密码页面
     */
    @RequestMapping(value = "/resetpwd.html")
    public String toReset(@RequestParam(value = "userId", required = true) String userId,
                          @RequestParam(value = "uuid", required = true) String uuid,
                          HttpServletRequest request, Model model) {
        if (userId != null && !"".equals(userId)) {
            SysUsersManual user = sysUsersService.selectByPrimaryKey(new Integer(userId));
            String token = user.getToken();
            if (token != null && !"".equals(token.trim())) {
                String[] strings = token.split("@");
                if (uuid.equals(strings[0].trim())
                        && System.currentTimeMillis() < new Long(strings[1])) {
                    return "redirect:" + port.trim() + "/resetPwd?userId=" + new Integer(userId)
                            + "&uuid=" + uuid + "&name=" + user.getUserName();
                } else {
                    return "redirect:" + port.trim() + "/resetPwdError?code=1";
                }
            } else {
                return "redirect:" + port.trim() + "/resetPwdError?code=2";
            }
        } else {
            return "redirect:" + port.trim() + "/resetPwdError?code=3";
        }
    }

    /**
     * 重设密码.
     *
     * @param request the request
     * @param pwd            新密码
     * @param userId the user id
     * @param uuid the uuid
     * @return 重设结果页
     */
    @RequestMapping(value = "/reset.html", method = RequestMethod.POST)
    @ResponseBody
    public String resetPassword(HttpServletRequest request,
                                @RequestParam(value = "password", required = true) String pwd,
                                @RequestParam(value = "userId", required = true) String userId,
                                @RequestParam(value = "uuid", required = true) String uuid) {
        if (null != userId && null != pwd && !"".equals(pwd.trim())) {
            String res = resetService.resetPassword(userId + "", uuid, pwd);
            OperateLog operateLog = new OperateLog();
            SysUsers sysUsers = sysUsersDao.selectByPrimaryKey(Integer.valueOf(userId));
            String userName = sysUsers.getUserName();
            operateLog.setOperateContent(userName + "修改密码");
            operateLog.setUserName(userName + "");
            operateLogServiceImpl.saveUserOperation(operateLog, request);
            return res;
        } else {
            // 需要重新发送邮件
            return "error";
        }
    }
}
