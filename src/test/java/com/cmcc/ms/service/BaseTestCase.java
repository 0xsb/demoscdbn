/**
 * @author ldy
 */
package com.cmcc.ms.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class BaseTestCase.
 *
 * @author ldy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "classpath:springmvc-servlet.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "springJTATransactionManager", defaultRollback = false)
public class BaseTestCase {

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test.
     */
    @Test
    public void test() {
    }

    /**
     * Creates the MD 5.
     *
     * @param moblie the moblie
     * @return the string
     */
    public static String createMD5(String moblie) {
        String str = "";
        if (!moblie.isEmpty()) {
            str = moblie + "9baa6424c0835dc1f10da529ba17495c";
        }

        StringBuilder sb = new StringBuilder();

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] raw = md.digest();

            for (int i = 0; i < raw.length; i++) {
                int h = (int) raw[i] & 0xff;

                String sh = Integer.toHexString(h);
                if (sh.length() < 2) {
                    sb.append(0);
                }
                sb.append(sh);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return (sb.toString());
    }

}
