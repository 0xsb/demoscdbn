/*
 * Project: demoms
 * 
 * File Created at 2017年6月29日
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

import com.cmcc.ms.entity.datashow.BaseData;
import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.entity.datashow.OverallAnalysis;


/**
 * The Interface ShowDataService.
 */
public interface ShowDataService {
    
    /**
     * Insert base data list.
     *
     * @param list the list
     */
    void insertBaseDataList(List<BaseData> list);
    
    /**
     * Gets the overall analysis list.
     *
     * @return the overall analysis list
     */
    List<OverallAnalysis> getOverallAnalysisList();
    
    /**
     * Gets the business traffic list.
     *
     * @param busBig the bus big
     * @return the business traffic list
     */
    List<BusinessTraffic> getBusinessTrafficList(String busBig);
    
    /**
     * Select sum trafficin.
     *
     * @param busBig the bus big
     * @return the double
     */
    Double selectSumTrafficin(String busBig);
    
    /**
     * Delete all.
     *
     * @return true, if successful
     */
    boolean deleteAll();
}


