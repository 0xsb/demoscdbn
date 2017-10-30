package com.cmcc.ms.service.system.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class SysCustomQueryServiceImplTest extends BaseTestCase {
    /**
     */
    @Autowired
    private SysCustomQueryServiceImpl sysCustomQueryServiceImpl;

    /**
     * Run the void setSysCustomQueryMapperManual(SqlSession) method test.
     * @throws Exception
     */
    @Test
    public void superManagerSelectTest() throws Exception {
        /*测试*/
        String sql = "SELECT * FROM sys_menus";
        LinkedList<LinkedHashMap<String, Object>> list = sysCustomQueryServiceImpl
                .superManagerSelect(sql);
        Assert.assertTrue(list.size() > 0);
    }
}
