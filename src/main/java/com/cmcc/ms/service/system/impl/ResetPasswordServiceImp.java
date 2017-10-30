/**
 * @author ldy
 */
package com.cmcc.ms.service.system.impl;

import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.utils.MD5;
import com.cmcc.ms.common.utils.PropertiesUtils;
import com.cmcc.ms.entity.system.MailSender;
import com.cmcc.ms.entity.system.SimpleMailSender;
import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersExample;
import com.cmcc.ms.entity.system.SysUsersExample.Criteria;
import com.cmcc.ms.mapper.SysUsersMapper;
import com.cmcc.ms.service.system.ResetPasswordService;


/**
 * 功能：密码重设服务接口实现。.
 */
@Service
public class ResetPasswordServiceImp implements ResetPasswordService {
    
    /** The sys users mapper. */
    @Autowired
    private SysUsersMapper sysUsersMapper;
    
    /** The s OSSEMAIL. */
    private String sOSSEMAIL = "13691363167@163.com";
    
    /** The s OSSEMAILPWD. */
    private String sOSSEMAILPWD = "962464ldy1013";
    
    /** The t OKENTIME. */
    private Integer tOKENTIME = 24 * 3600000;
    
    /** The s ERVERIP. */
    private String sERVERIP = "127.0.0.1";
    
    /** The s ERVERPOST. */
    private String sERVERPOST = "8080";
    
    /** The m AILSERVERHOST. */
    private String mAILSERVERHOST = "smtp.163.com";
    
    /** The m AILSERVERPORT. */
    private String mAILSERVERPORT = "25";
    
    /** The m AILTITLE. */
    private String mAILTITLE = "密码找回";
    
    /** The m AILCONTENT. */
    private String mAILCONTENT = "您申请了密码找回，请点击链接修改：";
    
    /** The b OSSMAILNAME. */
    @SuppressWarnings("unused")
    private String bOSSMAILNAME = "管理员";
    
    /** The send html mail. */
    @SuppressWarnings("unused")
    private boolean sendHtmlMail;

    /**
     * Instantiates a new reset password service imp.
     */
    public ResetPasswordServiceImp() {
        sOSSEMAIL = PropertiesUtils.findPropertiesKey("BOSSEMAIL", "/resetPwdConfig.properties");
        sOSSEMAILPWD = PropertiesUtils.findPropertiesKey("BOSSEMAILPWD",
                "/resetPwdConfig.properties");
        if (PropertiesUtils.findPropertiesKey("TOKENTIME", "/resetPwdConfig.properties") != null
                && !"".equals(PropertiesUtils.findPropertiesKey("TOKENTIME",
                        "/resetPwdConfig.properties").trim())) {
            tOKENTIME = new Integer(PropertiesUtils.findPropertiesKey("TOKENTIME",
                    "/resetPwdConfig.properties").trim()) * 3600000;
        }
        sERVERIP = PropertiesUtils.findPropertiesKey("SERVERIP", "/resetPwdConfig.properties");
        sERVERPOST = PropertiesUtils.findPropertiesKey("SERVERPOST", "/resetPwdConfig.properties");
        mAILSERVERHOST = PropertiesUtils.findPropertiesKey("MAILSERVERHOST",
                "/resetPwdConfig.properties");
        mAILSERVERPORT = PropertiesUtils.findPropertiesKey("MAILSERVERPORT",
                "/resetPwdConfig.properties");
        mAILTITLE = PropertiesUtils.findPropertiesKey("MAILTITLE", "/resetPwdConfig.properties");
        mAILCONTENT = PropertiesUtils
                .findPropertiesKey("MAILCONTENT", "/resetPwdConfig.properties");
        bOSSMAILNAME = PropertiesUtils.findPropertiesKey("BOSSMAILNAME",
                "/resetPwdConfig.properties");
    }

    /**
     * 发送修改密码邮件.
     *
     * @param basePath the base path
     * @param userId            用户id
     * @return the string
     * @throws MessagingException the messaging exception
     */
    @Override
    public String addValidateSendEmail(String basePath, String userId) throws MessagingException {
        String id = UUID.randomUUID().toString();
        SysUsers sysUsers = sysUsersMapper.selectByPrimaryKey(new Integer(userId.trim()));
        String email = sysUsers.getEmail();
        // 设置邮件对象
        MailSender mailSender = new MailSender();
        mailSender.setMailServerHost(mAILSERVERHOST);
        mailSender.setMailServerPort(mAILSERVERPORT);
        // 设置验证器
        mailSender.setValidate(true);
        // 发送邮箱地址
        mailSender.setFromAddress(sOSSEMAIL);
        // 接收邮箱地址
        mailSender.setToAddress(email);
        // 设置邮件用户名
        mailSender.setUserName(sOSSEMAIL);
        // 设置密码
        mailSender.setPassword(sOSSEMAILPWD);
        // 设置邮件主题
        mailSender.setSubject(mAILTITLE);
       
        // 生成链接
        String uri = "http://" + sERVERIP + ":" + sERVERPOST + basePath
                + "/getpassword/resetpwd.html" + "?uuid=" + id + "&userId=" + userId + "&time="
                + System.currentTimeMillis();
        mailSender.setContent(sysUsers.getUserRelname()
                + mAILCONTENT
                + PropertiesUtils.findPropertiesKey("TOKENTIME", "/resetPwdConfig.properties")
                        .trim() + "个小时。<a href=" + uri + ">点我重置密码！</a>");
        // 发送邮件
        if (SimpleMailSender.sendHtmlMail(mailSender)) {
            SysUsers sysUsesToken = sysUsersMapper.selectByPrimaryKey(new Integer(userId.trim()));
            sysUsesToken.setUserId(new Integer(userId.trim()));
            sysUsesToken.setToken(id + "@" + (System.currentTimeMillis() + tOKENTIME));
            sysUsersMapper.updateByPrimaryKey(sysUsesToken);
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 重置密码服务.
     *
     * @param userId the user id
     * @param uuid the uuid
     * @param newPassword the new password
     * @return the string
     */
    @Override
    public String resetPassword(String userId, String uuid, String newPassword) {
        String msg = "";
        SysUsersExample usesExample = new SysUsersExample();
        Criteria createCriteria = usesExample.createCriteria();
        createCriteria.andUserIdEqualTo(new Integer(userId.trim()));
        createCriteria.andTokenLike("%" + uuid + "%");
        List<SysUsers> list = sysUsersMapper.selectByExample(usesExample);
        if (list.size() == 1) {
            SysUsers sysUsers = list.get(0);
            sysUsers.setUserPassword(MD5.calcMD5(MD5.calcMD5(newPassword.trim())
                    + sysUsers.getUserName().trim()));
            sysUsers.setToken("");
            int res = sysUsersMapper.updateByPrimaryKey(sysUsers);
            if (res == 1) {
                msg = "success";
            } else {
                msg = "fail";
            }
        } else {
            msg = "fail";
        }
        return msg;
    }
}
