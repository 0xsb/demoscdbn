package com.cmcc.ms.service.system.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.query.CustomQueryInfo;
import com.cmcc.ms.service.BaseTestCase;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * @author chenyouchao-yl
 */
public class SysCustomQueryRecordServiceImplTest extends BaseTestCase {

    @Autowired
    private SysCustomQueryRecordServiceImpl sysCustomQueryRecordServiceImpl;

    /**
     * getAllCustomQueryRecord method
     */
    @Test
    public void getAllCustomQueryRecordTest() {
        PageBounds pb = new PageBounds(1, 15);
        List<CustomQueryInfo> list = sysCustomQueryRecordServiceImpl.getAllCustomQueryRecord(pb);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * getCustomQueryRecordSize method
     */
    @Test
    public void sysCustomQueryRecordServiceImplTest() {
        int customQueryRecordSize = sysCustomQueryRecordServiceImpl.getCustomQueryRecordSize();
        Assert.assertTrue(customQueryRecordSize > 0);
    }

    /**
     * method saveCustomQueryRecordTest
     */
    @Test
    @Rollback
    public void saveCustomQueryRecordTest() {
        CustomQueryInfo customQueryInfo = new CustomQueryInfo();
        customQueryInfo.setUserId(Integer.valueOf(1));
        customQueryInfo.setQueryName("ldyldy");
        int customQueryRecordSize = sysCustomQueryRecordServiceImpl
                .saveCustomQueryRecord(customQueryInfo);
        Assert.assertTrue(customQueryRecordSize > 0);
    }

}
