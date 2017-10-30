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
package com.cmcc.ms.service.datashow.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.entity.datashow.EverytimeGprs;
import com.cmcc.ms.entity.datashow.EverytimeGprsExample;
import com.cmcc.ms.mapper.EverytimeGprsMapper;
import com.cmcc.ms.service.datashow.EverytimeGprsService;

/**
 * The Class EverytimeGprsServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type EverytimeGprsServiceImpl.java
 * @Desc 
 * @date 2017年8月9日 上午11:21:58
 */
@Service
public class EverytimeGprsServiceImpl implements EverytimeGprsService {

    /** The mapper. */
    @Autowired
    private EverytimeGprsMapper mapper;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.EverytimeGprsService#insertEverytimeList(java.util.List)
     */
    @Override
    public void insertEverytimeList(List<EverytimeGprs> lsit) {
        for (EverytimeGprs everytimeGprs : lsit) {
            mapper.insert(everytimeGprs);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.EverytimeGprsService#selectAll()
     */
    @Override
    public List<EverytimeGprs> selectAll() {
        List<EverytimeGprs> list = mapper.selectByExample(new EverytimeGprsExample());
        return list;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年8月9日 bobo creat
 */
