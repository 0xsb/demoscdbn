/*
 * Project: demoms
 * 
 * File Created at 2017年8月9日
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

import com.cmcc.ms.entity.datashow.EverytimeGprs;


/**
 * The Interface EverytimeGprsService.
 *
 * @author bobo
 * @version 
 * @Type EverytimeGprsService.java
 * @Desc 
 * @date 2017年8月9日 上午11:21:22
 */
public interface EverytimeGprsService {
    
    /**
     * Insert everytime list.
     *
     * @param lsit the lsit
     */
    void insertEverytimeList(List<EverytimeGprs> lsit);
    
    /**
     * Select all.
     *
     * @return the list
     */
    List<EverytimeGprs> selectAll();

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年8月9日 bobo creat
 */