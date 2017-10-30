package com.cmcc.ms.exception;


/**
 * 自定义异常.
 *
 * @author ldy
 */
public class SessionTimeoutException extends Exception {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8629187408690566641L;

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        // return super.getMessage();
        return "您长时间未进行操作，系统已自动登出";
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    @Override
    public String toString() {
        return "您长时间未进行操作，系统已自动登出";
    }

}
