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
package com.cmcc.ms.service.datashow.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.entity.datashow.MapData;
import com.cmcc.ms.mapper.MapDataMapper;
import com.cmcc.ms.service.datashow.MapDataService;

/**
 * The Class MapDataServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type MapDataServiceImpl.java
 * @Desc 
 * @date 2017年7月21日 下午2:11:54
 */
@Service
public class MapDataServiceImpl implements MapDataService {

    /** The map data mapper. */
    @Autowired
    private MapDataMapper mapDataMapper;

    /** The date. */
    private Date date = Calendar.getInstance().getTime();

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.MapDataService#addMapDataiList(java.util.List)
     */
    @Override
    public void addMapDataiList(List<MapData> list) {
        for (MapData mapData : list) {
            mapData.setCreatetime(date);
            mapDataMapper.insert(mapData);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.MapDataService#selectMaxCreatetime()
     */
    @Override
    public Date selectMaxCreatetime() {
        return mapDataMapper.selectMaxCreatetime();
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.MapDataService#findMapDataByTime(java.util.Date)
     */
    @Override
    public List<MapData> findMapDataByTime(Date date) {
        return mapDataMapper.findMapDataByTime(date);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月21日 bobo creat
 */
