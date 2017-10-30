/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import javax.mail.MessagingException;

import org.springframework.transaction.annotation.Transactional;



/**
 * The Interface ResetPasswordService.
 */
public interface ResetPasswordService {
    
    /**
     * 发送修改密码邮件.
     *
     * @param basePath the base path
     * @param userId the user id
     * @return the string
     * @throws MessagingException the messaging exception
     */
    @Transactional
    public String addValidateSendEmail(String basePath, String userId) throws MessagingException;

    /**
     * 重置密码服务.
     *
     * @param userId the user id
     * @param uuid the uuid
     * @param newPassword the new password
     * @return the string
     */
    @Transactional
    public String resetPassword(String userId, String uuid, String newPassword);
}
