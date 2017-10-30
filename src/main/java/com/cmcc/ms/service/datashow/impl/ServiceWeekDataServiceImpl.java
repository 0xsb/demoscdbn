/*
 * Project: demoms
 * 
 * File Created at 2017年7月18日
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

import com.cmcc.ms.entity.datashow.IdcWeek;
import com.cmcc.ms.entity.datashow.ProvinceCacheWeek;
import com.cmcc.ms.entity.datashow.ProvinceOttWeek;
import com.cmcc.ms.entity.datashow.UnifiedCacheWeek;
import com.cmcc.ms.entity.datashow.UnifiedCdnWeek;
import com.cmcc.ms.mapper.IdcWeekMapper;
import com.cmcc.ms.mapper.ProvinceCacheWeekMapper;
import com.cmcc.ms.mapper.ProvinceOttWeekMapper;
import com.cmcc.ms.mapper.UnifiedCacheWeekMapper;
import com.cmcc.ms.mapper.UnifiedCdnWeekMapper;
import com.cmcc.ms.service.datashow.ServiceWeekDataService;

/**
 * The Class ServiceWeekDataServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type ServiceWeekDataServiceImpl.java
 * @Desc 
 * @date 2017年7月18日 上午10:04:49
 */
@Service
public class ServiceWeekDataServiceImpl implements ServiceWeekDataService {

    /** The cdn mapper. */
    @Autowired
    private UnifiedCdnWeekMapper cdnMapper;

    /** The u cache mapper. */
    @Autowired
    private UnifiedCacheWeekMapper uCacheMapper;

    /** The ott mapper. */
    @Autowired
    private ProvinceOttWeekMapper ottMapper;

    /** The p cache mapper. */
    @Autowired
    private ProvinceCacheWeekMapper pCacheMapper;

    /** The idc mapper. */
    @Autowired
    private IdcWeekMapper idcMapper;

    /** The date. */
    private Date date = Calendar.getInstance().getTime();

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#addCDNList(java.util.List)
     */
    @Override
    public void addCDNList(List<UnifiedCdnWeek> list) {
        for (UnifiedCdnWeek unifiedCdnWeek : list) {
            unifiedCdnWeek.setCreatetime(date);
            cdnMapper.insert(unifiedCdnWeek);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#addUnfiedCacheList(java.util.List)
     */
    @Override
    public void addUnfiedCacheList(List<UnifiedCacheWeek> list) {
        for (UnifiedCacheWeek unifiedCacheWeek : list) {
            unifiedCacheWeek.setCreatetime(date);
            uCacheMapper.insert(unifiedCacheWeek);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#addOTTList(java.util.List)
     */
    @Override
    public void addOTTList(List<ProvinceOttWeek> list) {
        for (ProvinceOttWeek provinceOttWeek : list) {
            provinceOttWeek.setCreatetime(date);
            ottMapper.insert(provinceOttWeek);
        }

    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#addProvinceCacheList(java.util.List)
     */
    @Override
    public void addProvinceCacheList(List<ProvinceCacheWeek> list) {
        for (ProvinceCacheWeek provinceCacheWeek : list) {
            provinceCacheWeek.setCreatetime(date);
            pCacheMapper.insert(provinceCacheWeek);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#addIDCiList(java.util.List)
     */
    @Override
    public void addIDCiList(List<IdcWeek> list) {
        for (IdcWeek idcWeek : list) {
            idcWeek.setCreatetime(date);
            idcMapper.insert(idcWeek);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#findNewCDNList(java.util.Date)
     */
    @Override
    public List<UnifiedCdnWeek> findNewCDNList(Date createtime) {
        List<UnifiedCdnWeek> list = cdnMapper.findCDNByTime(createtime);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#findNewUnfiedCacheList(java.util.Date)
     */
    @Override
    public List<UnifiedCacheWeek> findNewUnfiedCacheList(Date createtime) {
        List<UnifiedCacheWeek> list = uCacheMapper.findUCacheByTime(createtime);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#findNewOTTList(java.util.Date)
     */
    @Override
    public List<ProvinceOttWeek> findNewOTTList(Date createtime) {
        List<ProvinceOttWeek> list = ottMapper.findOTTByTime(createtime);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#findNewProvinceCacheList(java.util.Date)
     */
    @Override
    public List<ProvinceCacheWeek> findNewProvinceCacheList(Date createtime) {
        List<ProvinceCacheWeek> list = pCacheMapper.findPCacheByTime(createtime);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#findNewIDCiList(java.util.Date)
     */
    @Override
    public List<IdcWeek> findNewIDCiList(Date createtime) {
        List<IdcWeek> list = idcMapper.findIDCByTime(createtime);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceWeekDataService#selectMaxCreatetime()
     */
    @Override
    public Date selectMaxCreatetime() {
        Date date = cdnMapper.selectMaxCreatetime();
        return date;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月18日 bobo creat
 */
