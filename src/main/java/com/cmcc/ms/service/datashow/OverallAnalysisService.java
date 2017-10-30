/*
 * Project: demoms
 * 
 * File Created at 2017年6月30日
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

import com.cmcc.ms.entity.datashow.OverallAnalysis;


/**
 * The Interface OverallAnalysisService.
 *
 * @author bobo
 * @version 
 * @Type OverallAnalysisService.java
 * @Desc 
 * @date 2017年6月30日 下午4:54:46
 */
public interface OverallAnalysisService {
    
    /**
     * Insert over analysis list.
     *
     * @param list the list
     */
    void insertOverAnalysisList(List<OverallAnalysis> list);
    
    /**
     * Select OA list.
     *
     * @return the list
     */
    List<OverallAnalysis> selectOAList();

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月30日 bobo creat
 */