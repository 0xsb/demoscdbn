package com.cmcc.ms.exception;


/**
 * The Class SessionAuthException.
 *
 * @author ldy
 */
public class SessionAuthException extends Exception {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8629187408690566641L;

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        // return super.getMessage();
        return "您的账户已在别处登录";
    }

}
