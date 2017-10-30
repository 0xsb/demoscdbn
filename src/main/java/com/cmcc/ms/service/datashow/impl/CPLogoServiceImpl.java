/*
 * Project: demoms
 * 
 * File Created at 2017年10月17日
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

import com.cmcc.ms.entity.datashow.CpLogo;
import com.cmcc.ms.entity.datashow.CpLogoExample;
import com.cmcc.ms.mapper.CpLogoMapper;
import com.cmcc.ms.service.datashow.CPLogoService;

// TODO: Auto-generated Javadoc
/**
 * The Class CPLogoServiceImpl.
 *
 * @author bobo
 * @version 
 * @Type CPLogoServiceImpl.java
 * @Desc 
 * @date 2017年10月17日 上午10:42:08
 */
@Service
public class CPLogoServiceImpl implements CPLogoService{
    
    /** The mapper. */
    @Autowired
    private CpLogoMapper mapper;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.datashow.CPLogoService#selectAll()
     */
    @Override
    public List<CpLogo> selectAll() {
        List<CpLogo> list = mapper.selectByExample(new CpLogoExample());
        return list;
    }
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年10月17日 bobo creat
 */