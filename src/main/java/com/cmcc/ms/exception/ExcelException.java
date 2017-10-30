/*
 * Project: demoms
 * 
 * File Created at 2017年6月28日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.exception;


/**
 * The Class ExcelException.
 *
 * @author bobo
 * @version 
 * @Type ExcelException.java
 * @Desc 
 * @date 2017年6月28日 上午11:13:42
 */
@SuppressWarnings("serial")
public class ExcelException extends Exception {
    
    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        // return super.getMessage();
        return "导出文件异常";
    }

    /**
     * Instantiates a new excel exception.
     */
    public ExcelException() {
    }

    /**
     * Instantiates a new excel exception.
     *
     * @param message the message
     */
    public ExcelException(String message) {
        super(message);
    }

    /**
     * Instantiates a new excel exception.
     *
     * @param cause the cause
     */
    public ExcelException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new excel exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public ExcelException(String message, Throwable cause) {
        super(message, cause);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月28日 bobo creat
 */
