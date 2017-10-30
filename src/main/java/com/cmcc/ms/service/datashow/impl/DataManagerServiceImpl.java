/*
 * Project: demoms
 * 
 * File Created at 2017年10月18日
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

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.utils.TimeUtils;
import com.cmcc.ms.entity.datamanager.LocalProvRate;
import com.cmcc.ms.entity.datamanager.LocalProvRateExample;
import com.cmcc.ms.entity.datamanager.LocalProvRateExample.Criteria;
import com.cmcc.ms.entity.datamanager.LocalProvRateExtendDay;
import com.cmcc.ms.entity.datamanager.LocalProvRateExtendDayExample;
import com.cmcc.ms.mapper.LocalProvRateExtendDayMapper;
import com.cmcc.ms.mapper.LocalProvRateMapper;
import com.cmcc.ms.service.datashow.DataManagerService;

/**
 * @Type DataManagerServiceImpl.java
 * @Desc 
 * @author bobo
 * @date 2017年10月18日 下午3:54:47
 * @version 
 */
@Service
public class DataManagerServiceImpl implements DataManagerService {

    @Autowired
    LocalProvRateMapper proMapper;
    @Autowired
    LocalProvRateExtendDayMapper localProvRateExtendDayMapper;
    @Override
    public List<LocalProvRate> selectAll(String date, String province) {
        LocalProvRateExample localProvRateExample = new LocalProvRateExample();
        Criteria createCriteria = localProvRateExample.createCriteria();
        if(province!=null){
            createCriteria.andProvinceEqualTo(province.trim());
        }
        if (date != null) {
            Date dateD;
            try {
                dateD = TimeUtils.getDateFromString(date, TimeUtils.FORMAT_DATE);
                createCriteria.andDataEqualTo(dateD);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return proMapper.selectByExample(localProvRateExample);
    }

    @Override
    public List<LocalProvRateExtendDay> selectAllByDate(String date) {
        LocalProvRateExtendDayExample localProvRateExtendDayExample = new LocalProvRateExtendDayExample();
        com.cmcc.ms.entity.datamanager.LocalProvRateExtendDayExample.Criteria createCriteria = localProvRateExtendDayExample
                .createCriteria();
        if (null != date) {
            createCriteria.andDatestrEqualTo(date);
        }
        List<LocalProvRateExtendDay> selectByExample = localProvRateExtendDayMapper.selectByExample(localProvRateExtendDayExample);
        if(selectByExample==null||selectByExample.size()==0){
            List<LocalProvRate> selectAllToday = selectAll(date, null);
            Date dateD = new Date();
            try {
                dateD = TimeUtils.getDateFromString(date, TimeUtils.FORMAT_DATE);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date prevDay = TimeUtils.getPrevDay(dateD);
            String preDayStr = TimeUtils.getStringFromTime(prevDay, TimeUtils.FORMAT_DATE);
            List<LocalProvRate> selectAllPreday = selectAll(preDayStr, null);
            for (LocalProvRate rateToday : selectAllToday) {
                for (LocalProvRate ratePre : selectAllPreday) {
                    if(ratePre.getProvince().equals(rateToday.getProvince())){
                        LocalProvRateExtendDay localProvRateExtendDay = new LocalProvRateExtendDay();
                        if(ratePre.getLocalProvR()>rateToday.getLocalProvR()){
                            localProvRateExtendDay.setDayOnDay(-1f);
                        }else if(ratePre.getLocalProvR()<rateToday.getLocalProvR()){
                            localProvRateExtendDay.setDayOnDay(1f);
                        }else {
                            localProvRateExtendDay.setDayOnDay(0f);
                        }
                        localProvRateExtendDay.setProvince(ratePre.getProvince());
                        localProvRateExtendDay.setDatestr(date);
                        localProvRateExtendDay.setLocalProvR(rateToday.getLocalProvR());
                        localProvRateExtendDayMapper.insertSelective(localProvRateExtendDay);
                    }
                }
            }
            selectByExample = localProvRateExtendDayMapper.selectByExample(localProvRateExtendDayExample);
        }
        return selectByExample;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年10月18日 bobo creat
 */
