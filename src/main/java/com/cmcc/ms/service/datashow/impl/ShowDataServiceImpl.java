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
package com.cmcc.ms.service.datashow.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.entity.datashow.BaseData;
import com.cmcc.ms.entity.datashow.BaseDataExample;
import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.entity.datashow.OverallAnalysis;
import com.cmcc.ms.mapper.BaseDataMapper;
import com.cmcc.ms.service.datashow.ShowDataService;

/**
 * The Class ShowDataServiceImp.
 */
@Service
public class ShowDataServiceImpl implements ShowDataService {

    /** The base data mapper. */
    @Autowired
    private BaseDataMapper baseDataMapper;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ShowDataService#insertBaseDataList(java.util.List)
     */
    @Override
    public void insertBaseDataList(List<BaseData> list) {
        for (BaseData baseData : list) {
            baseData.setId(baseData.getDevName() + baseData.getPortName());
            baseData.setBandwidth(baseData.getBandwidth() / 1024 / 1024 / 1024);
            baseData.setTrafficin(baseData.getTrafficin() / 1024 / 1024 / 1024);
            baseData.setTrafficout(baseData.getTrafficout() / 1024 / 1024 / 1024);
            baseDataMapper.insertSelective(baseData);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ShowDataService#getOverallAnalysisList()
     */
    @Override
    public List<OverallAnalysis> getOverallAnalysisList() {
        List<OverallAnalysis> list = baseDataMapper.selectOverallAnalysisList();
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ShowDataService#getBusinessTrafficList(java.lang.String)
     */
    @Override
    public List<BusinessTraffic> getBusinessTrafficList(String busBig) {
        List<BusinessTraffic> list = baseDataMapper.selectBusinessTrafficList(busBig);
        return list;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ShowDataService#selectSumTrafficin(java.lang.String)
     */
    @Override
    public Double selectSumTrafficin(String busBig) {
        Double sumTrafficin = baseDataMapper.selectSumTrafficin(busBig);
        return sumTrafficin;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.ShowDataService#deleteAll()
     */
    @Override
    public boolean deleteAll() {
        BaseDataExample dataExample = new BaseDataExample();
        int deleteByExample = baseDataMapper.deleteByExample(dataExample);
        return deleteByExample > 0;
    }

}
