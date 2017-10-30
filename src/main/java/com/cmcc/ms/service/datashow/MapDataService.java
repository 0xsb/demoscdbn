/*
 * Project: demoms
 * 
 * File Created at 2017年7月21日
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

import com.cmcc.ms.entity.datashow.MapData;



/**
 * The Interface MapDataService.
 *
 * @author bobo
 * @version 
 * @Type MapDataService.java
 * @Desc 
 * @date 2017年7月21日 下午2:11:35
 */
public interface MapDataService {
    
    /**
     * Adds the map datai list.
     *
     * @param list the list
     */
    void addMapDataiList(List<MapData> list);
    
    /**
     * Select max createtime.
     *
     * @return the date
     */
    Date selectMaxCreatetime();
    
    /**
     * Find map data by time.
     *
     * @param date the date
     * @return the list
     */
    List<MapData> findMapDataByTime(Date date);

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月21日 bobo creat
 */