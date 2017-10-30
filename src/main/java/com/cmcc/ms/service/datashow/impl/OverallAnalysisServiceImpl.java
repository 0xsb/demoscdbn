/*
 * Project: demoms
 * 
 * File Created at 2017年6月30日
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
import com.cmcc.ms.entity.datashow.OverallAnalysis;
import com.cmcc.ms.entity.datashow.OverallAnalysisExample;
import com.cmcc.ms.mapper.OverallAnalysisMapper;
import com.cmcc.ms.service.datashow.OverallAnalysisService;

/**
 * The Class OverallAnalysisServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type OverallAnalysisServiceImp.java
 * @Desc 
 * @date 2017年6月30日 下午4:55:25
 */
@Service
public class OverallAnalysisServiceImpl implements OverallAnalysisService {

    /** The overall analysis mapper. */
    @Autowired
    private OverallAnalysisMapper overallAnalysisMapper;

    /**
     * 批量导入list.
     *
     * @param list the list
     */
    @Override
    public void insertOverAnalysisList(List<OverallAnalysis> list) {
        for (OverallAnalysis overallAnalysis : list) {
            String name = overallAnalysis.getName();
            if (!StringUtils.isEmpty(name)) {
                if ("省际直连".equals(name)) {
                    overallAnalysis.setName("CMNET国际");
                }
                if ("免费对等直连".equals(name)) {
                    overallAnalysis.setName("免费直连");
                }
                if ("付费穿透".equals(name)) {
                    overallAnalysis.setName("付费穿透");
                }
                if ("国际公司客户".equals(name)) {
                    overallAnalysis.setName("收费用户");
                }
                if ("付费对等直连".equals(name)) {
                    overallAnalysis.setName("付费直连");
                }
            }
            Date date = Calendar.getInstance().getTime();
            overallAnalysis.setCreattime(date);
            overallAnalysisMapper.insert(overallAnalysis);
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.OverallAnalysisService#selectOAList()
     */
    @Override
    public List<OverallAnalysis> selectOAList() {
        OverallAnalysisExample example = new OverallAnalysisExample();
        List<OverallAnalysis> list = overallAnalysisMapper.selectByExample(example);
        return list;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月30日 bobo creat
 */
