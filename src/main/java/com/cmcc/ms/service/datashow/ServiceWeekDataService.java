/*
 * Project: demoms
 * 
 * File Created at 2017年7月17日
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

import java.util.Date;
import java.util.List;

import com.cmcc.ms.entity.datashow.IdcWeek;
import com.cmcc.ms.entity.datashow.ProvinceCacheWeek;
import com.cmcc.ms.entity.datashow.ProvinceOttWeek;
import com.cmcc.ms.entity.datashow.UnifiedCacheWeek;
import com.cmcc.ms.entity.datashow.UnifiedCdnWeek;



/**
 * The Interface ServiceWeekDataService.
 *
 * @author bobo
 * @version 
 * @Type ServiceDayDataService.java
 * @Desc 
 * @date 2017年7月17日 上午10:53:52
 */
public interface ServiceWeekDataService {
    
    /**
     * Adds the CDN list.
     *
     * @param list the list
     */
    void addCDNList(List<UnifiedCdnWeek> list);
    
    /**
     * Adds the unfied cache list.
     *
     * @param list the list
     */
    void addUnfiedCacheList(List<UnifiedCacheWeek> list);
    
    /**
     * Adds the OTT list.
     *
     * @param list the list
     */
    void addOTTList(List<ProvinceOttWeek> list);
    
    /**
     * Adds the province cache list.
     *
     * @param list the list
     */
    void addProvinceCacheList(List<ProvinceCacheWeek> list);
    
    /**
     * Adds the ID ci list.
     *
     * @param list the list
     */
    void addIDCiList(List<IdcWeek> list);
    
    /**
     * Find new CDN list.
     *
     * @param createtime the createtime
     * @return the list
     */
    List<UnifiedCdnWeek> findNewCDNList(Date createtime);
    
    /**
     * Find new unfied cache list.
     *
     * @param createtime the createtime
     * @return the list
     */
    List<UnifiedCacheWeek> findNewUnfiedCacheList(Date createtime);
    
    /**
     * Find new OTT list.
     *
     * @param createtime the createtime
     * @return the list
     */
    List<ProvinceOttWeek> findNewOTTList(Date createtime);
    
    /**
     * Find new province cache list.
     *
     * @param createtime the createtime
     * @return the list
     */
    List<ProvinceCacheWeek> findNewProvinceCacheList(Date createtime);
    
    /**
     * Find new ID ci list.
     *
     * @param createtime the createtime
     * @return the list
     */
    List<IdcWeek> findNewIDCiList(Date createtime);
    
    /**
     * Select max createtime.
     *
     * @return the date
     */
    Date selectMaxCreatetime();

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月17日 bobo creat
 */