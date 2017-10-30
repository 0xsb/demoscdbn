/*
 * Project: demoms
 * 
 * File Created at 2017年7月3日
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



import com.cmcc.ms.entity.datashow.BusinessTraffic;


/**
 * The Interface BusinessTrafficService.
 *
 * @author bobo
 * @version 
 * @Type PayThroughService.java
 * @Desc 
 * @date 2017年7月3日 下午3:31:56
 */
public interface BusinessTrafficService {
    
    /**
     * Insert business traffic list.
     *
     * @param list the list
     */
    void insertBusinessTrafficList(List<BusinessTraffic> list);
    
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月3日 bobo creat
 */