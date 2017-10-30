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
package com.cmcc.ms.service.datashow.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.mapper.BusinessTrafficMapper;
import com.cmcc.ms.service.datashow.BusinessTrafficService;

/**
 * The Class BusinessTrafficServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type PayThroughServiceImpl.java
 * @Desc 
 * @date 2017年7月3日 下午3:35:55
 */
@Service
public class BusinessTrafficServiceImpl implements BusinessTrafficService {

    /** The business traffic mapper. */
    @Autowired
    private BusinessTrafficMapper businessTrafficMapper;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.BusinessTrafficService#insertBusinessTrafficList(java.util.List)
     */
    @Override
    public void insertBusinessTrafficList(List<BusinessTraffic> list) {
        for (BusinessTraffic businessTraffic : list) {
            Date date = Calendar.getInstance().getTime();
            businessTraffic.setCreatetime(date);
            String business = businessTraffic.getBusiness();
            if (!StringUtils.isEmpty(business)) {
                if ("省际直连".equals(business)) {
                    businessTraffic.setBusiness("CMNET国际");
                }
                if ("免费对等直连".equals(business)) {
                    businessTraffic.setBusiness("免费直连");
                }
                if ("付费穿透".equals(business)) {
                    businessTraffic.setBusiness("付费穿透");
                }
                if ("国际公司客户".equals(business)) {
                    businessTraffic.setBusiness("收费用户");
                }
                if ("付费对等直连".equals(business)) {
                    businessTraffic.setBusiness("付费直连");
                }
            }
            businessTrafficMapper.insert(businessTraffic);
        }

    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月3日 bobo creat
 */
