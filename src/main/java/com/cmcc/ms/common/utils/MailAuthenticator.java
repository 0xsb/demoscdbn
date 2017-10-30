/*
 * 
 */
package com.cmcc.ms.common.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


/**
 * 功能：验证器 Date: 14-3-4 Time: 下午12:47.
 */
public class MailAuthenticator extends Authenticator {

    /** The user name. */
    String userName = null;

    /** The password. */
    String password = null;

    /**
     * Instantiates a new mail authenticator.
     */
    public MailAuthenticator() {
    }

    /**
     * Instantiates a new mail authenticator.
     *
     * @param username the username
     * @param password the password
     */
    public MailAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    /* (non-Javadoc)
     * @see javax.mail.Authenticator#getPasswordAuthentication()
     */
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
