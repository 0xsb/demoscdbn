package com.cmcc.ms.service.system;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.query.CustomQueryInfo;
import com.cmcc.ms.service.BaseTestCase;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 *
 * @author zhangxu-ws
 */
public class SysCustomQueryRecordServiceTest extends BaseTestCase {

    @Autowired
    private SysCustomQueryRecordService sysCustomQueryRecordService;

    /**
     * getAllCustomQueryRecord method
     */
    @Test
    public void getAllCustomQueryRecordTest() {
        PageBounds pb = new PageBounds(1, 15);
        List<CustomQueryInfo> list = sysCustomQueryRecordService.getAllCustomQueryRecord(pb);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * getCustomQueryRecordSize method
     */
    @Test
    public void sysCustomQueryRecordServiceImplTest() {
        int customQueryRecordSize = sysCustomQueryRecordService.getCustomQueryRecordSize();
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
        int customQueryRecordSize = sysCustomQueryRecordService
                .saveCustomQueryRecord(customQueryInfo);
        Assert.assertTrue(customQueryRecordSize > 0);
    }

}
