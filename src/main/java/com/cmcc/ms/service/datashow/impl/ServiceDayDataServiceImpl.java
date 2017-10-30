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
package com.cmcc.ms.service.datashow.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.entity.datashow.IdcDay;
import com.cmcc.ms.entity.datashow.IdcDayExample;
import com.cmcc.ms.entity.datashow.ProvinceCacheDay;
import com.cmcc.ms.entity.datashow.ProvinceCacheDayExample;
import com.cmcc.ms.entity.datashow.ProvinceOttDay;
import com.cmcc.ms.entity.datashow.ProvinceOttDayExample;
import com.cmcc.ms.entity.datashow.UnifiedCacheDay;
import com.cmcc.ms.entity.datashow.UnifiedCacheDayExample;
import com.cmcc.ms.entity.datashow.UnifiedCdnDay;
import com.cmcc.ms.entity.datashow.UnifiedCdnDayExample;
import com.cmcc.ms.mapper.IdcDayMapper;
import com.cmcc.ms.mapper.ProvinceCacheDayMapper;
import com.cmcc.ms.mapper.ProvinceOttDayMapper;
import com.cmcc.ms.mapper.UnifiedCacheDayMapper;
import com.cmcc.ms.mapper.UnifiedCdnDayMapper;
import com.cmcc.ms.service.datashow.ServiceDayDataService;

/**
 * The Class ServiceDayDataServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type ServiceDayDataServiceImpl.java
 * @Desc 
 * @date 2017年7月17日 上午10:54:39
 */
@Service
public class ServiceDayDataServiceImpl implements ServiceDayDataService {

    /** The cdn mapper. */
    @Autowired
    private UnifiedCdnDayMapper cdnMapper;

    /** The unified cache mapper. */
    @Autowired
    private UnifiedCacheDayMapper unifiedCacheMapper;

    /** The idc mapper. */
    @Autowired
    private IdcDayMapper idcMapper;

    /** The province cache mapper. */
    @Autowired
    private ProvinceCacheDayMapper provinceCacheMapper;

    /** The ott mapper. */
    @Autowired
    private ProvinceOttDayMapper ottMapper;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#addCDNList(java.util.List)
     */
    @Override
    public void addCDNList(List<UnifiedCdnDay> list) {
        for (UnifiedCdnDay unifiedCdnDay : list) {
            Date date = Calendar.getInstance().getTime();
            unifiedCdnDay.setCreatetime(date);
            cdnMapper.insert(unifiedCdnDay);
        }

    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#addUnfiedCacheList(java.util.List)
     */
    @Override
    public void addUnfiedCacheList(List<UnifiedCacheDay> list) {
        for (UnifiedCacheDay unifiedCacheDay : list) {
            Date date = Calendar.getInstance().getTime();
            unifiedCacheDay.setCreatetime(date);
            unifiedCacheMapper.insert(unifiedCacheDay);
        }

    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#addOTTList(java.util.List)
     */
    @Override
    public void addOTTList(List<ProvinceOttDay> list) {
        for (ProvinceOttDay provinceOttDay : list) {
            Date date = Calendar.getInstance().getTime();
            provinceOttDay.setCreatetime(date);
            ottMapper.insert(provinceOttDay);
        }

    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#addProvinceCacheList(java.util.List)
     */
    @Override
    public void addProvinceCacheList(List<ProvinceCacheDay> list) {
        for (ProvinceCacheDay provinceCacheDay : list) {
            Date date = Calendar.getInstance().getTime();
            provinceCacheDay.setCreatetime(date);
            provinceCacheMapper.insert(provinceCacheDay);
        }

    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#addIDCiList(java.util.List)
     */
    @Override
    public void addIDCiList(List<IdcDay> list) {
        for (IdcDay idcDay : list) {
            Date date = Calendar.getInstance().getTime();
            idcDay.setCreatetime(date);
            idcMapper.insert(idcDay);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#findNewCDNList(java.util.Date)
     */
    @Override
    public List<UnifiedCdnDay> findNewCDNList(Date createtime) {
        UnifiedCdnDayExample example = new UnifiedCdnDayExample();
        example.createCriteria().andCreatetimeEqualTo(createtime);
        List<UnifiedCdnDay> list = cdnMapper.selectByExample(example);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#findNewUnfiedCacheList(java.util.Date)
     */
    @Override
    public List<UnifiedCacheDay> findNewUnfiedCacheList(Date createtime) {
        UnifiedCacheDayExample example = new UnifiedCacheDayExample();
        example.createCriteria().andCreatetimeEqualTo(createtime);
        List<UnifiedCacheDay> list = unifiedCacheMapper.selectByExample(example);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#findNewOTTList(java.util.Date)
     */
    @Override
    public List<ProvinceOttDay> findNewOTTList(Date createtime) {
        ProvinceOttDayExample example = new ProvinceOttDayExample();
        example.createCriteria().andCreatetimeEqualTo(createtime);
        List<ProvinceOttDay> list = ottMapper.selectByExample(example);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#findNewProvinceCacheList(java.util.Date)
     */
    @Override
    public List<ProvinceCacheDay> findNewProvinceCacheList(Date createtime) {
        ProvinceCacheDayExample example = new ProvinceCacheDayExample();
        example.createCriteria().andCreatetimeEqualTo(createtime);
        List<ProvinceCacheDay> list = provinceCacheMapper.selectByExample(example);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#findNewIDCiList(java.util.Date)
     */
    @Override
    public List<IdcDay> findNewIDCiList(Date createtime) {
        IdcDayExample example = new IdcDayExample();
        example.createCriteria().andCreatetimeEqualTo(createtime);
        List<IdcDay> list = idcMapper.selectByExample(example);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ServiceDayDataService#selectMaxCreatetime()
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
 * 2017年7月17日 bobo creat
 */
