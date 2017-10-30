package com.cmcc.ms.service.system;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @generatedBy CodePro at 17-8-30 上午11:06
 * @author zhangxu-ws
 */
public class ResetPasswordServiceTest extends BaseTestCase {

    @Autowired
    private ResetPasswordService esetPasswordService;

    /**
     * Run the String addValidateSendEmail(SqlSession) method test.
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void addValidateSendEmailTest() throws Exception {
        String basePath = "测试";
        esetPasswordService.addValidateSendEmail(basePath, String.valueOf(1303));
    }

    /**
     * Run the String resetPassword(String userId, String uuid, String newPassword) method test.
     * @throws Exception
     *
     */
    @Test
    @Rollback
    public void resetPasswordTest() throws Exception {
        String uuid = "";
        String newPassword = "";
        esetPasswordService.resetPassword(String.valueOf(1024L), uuid, newPassword);
    }
}
