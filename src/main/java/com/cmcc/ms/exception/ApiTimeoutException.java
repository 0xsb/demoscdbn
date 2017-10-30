/*
 * Project: cmcciwms
 * 
 * File Created at 2017年3月1日
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
 * The Class ApiTimeoutException.
 *
 * @author baoyou
 * @version 
 * @Type ApiTimeoutException.java
 * @Desc 
 * @date 2017年3月1日 下午2:00:38
 */
public class ApiTimeoutException extends Exception {

    /** 序列化. */
    private static final long serialVersionUID = -844272875940003461L;
    
    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        // return super.getMessage();
        return "请求API接口超时";
    }

    /**
     * Instantiates a new api timeout exception.
     */
    public ApiTimeoutException() {
        super();
    }

    /**
     * Instantiates a new api timeout exception.
     *
     * @param message the message
     */
    public ApiTimeoutException(String message) {
        super(message);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年3月1日 baoyou creat
 */
