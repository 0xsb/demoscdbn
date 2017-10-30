package com.cmcc.ms.exception;


/**
 * The Class AuthException.
 *
 * @author ldy
 */
public class AuthException extends Exception {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8629187408690566641L;

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return "请求权限异常";
    }

}
