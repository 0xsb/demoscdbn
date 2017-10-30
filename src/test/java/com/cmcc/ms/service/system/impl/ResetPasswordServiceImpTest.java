package com.cmcc.ms.service.system.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class ResetPasswordServiceImpTest extends BaseTestCase {

    @Autowired
    private ResetPasswordServiceImp resetPasswordServiceImp;

    /**
     * Run the String addValidateSendEmail(SqlSession) method test.
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addValidateSendEmailTest() throws Exception {
      /*  String basePath = "测试";
        String value = resetPasswordServiceImp.addValidateSendEmail(basePath, String.valueOf(2));
        Assert.assertNotNull(value);*/
    }

    /**
     * Run the String resetPassword(String userId, String uuid, String newPassword) method test.
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void resetPasswordTest() throws Exception {
       /* String uuid = "6f4863ea-745d-446e-90e7-bc2713b10239@1500453357360";
        String newPassword = "asd123";
        String value = resetPasswordServiceImp.resetPassword(String.valueOf(2), uuid, newPassword);
        Assert.assertNotNull(value);*/
    }
}
