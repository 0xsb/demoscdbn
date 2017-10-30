/*
 * Project: demoms
 * 
 * File Created at 2017年10月18日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.service.datashow;

import java.util.List;

import com.cmcc.ms.entity.datamanager.LocalProvRate;
import com.cmcc.ms.entity.datamanager.LocalProvRateExtendDay;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataManagerService.
 *
 * @author bobo
 * @version 
 * @Type DataManagerService.java
 * @Desc 
 * @date 2017年10月18日 下午3:54:24
 */
public interface DataManagerService {

    /**
     * Select all.
     *
     * @param date the date
     * @param province the province
     * @return the list
     */
    public List<LocalProvRate> selectAll(String date,String province);

    /**
     * Select all by date.
     *
     * @param date the date
     * @return the list
     */
    public List<LocalProvRateExtendDay> selectAllByDate(String date);

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年10月18日 bobo creat
 */
