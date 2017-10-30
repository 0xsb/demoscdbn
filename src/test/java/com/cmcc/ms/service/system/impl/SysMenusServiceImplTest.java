package com.cmcc.ms.service.system.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @author zhangxu-ws
 */
public class SysMenusServiceImplTest extends BaseTestCase {
    @Autowired
    private SysMenusServiceImpl sysMenusServiceImpl;

    /**
     * Run the List<SysMenus> getMenusByRoleId(int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void getMenusByRoleIdTest() {
        List<SysMenus> list = sysMenusServiceImpl.getMenusByRoleId(1);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * Run the List<SysMenus> getMenusByType(int) method test.
     *
     * @throws Exception
     *  type参数
     */
    @Test
    public void getMenusByTypeTest() {
        List<SysMenus> list = sysMenusServiceImpl.getMenusByType(-200);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * Run the List<SysMenus> getSysMenusList() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void getSysMenusListTest() {
        List<SysMenus> list = sysMenusServiceImpl.getSysMenusList();
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * Run the SysMenus selectByPrimaryKey(int menuId) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void selectByPrimaryKeyTest() {
        SysMenus value = sysMenusServiceImpl.selectByPrimaryKey(1);
        Assert.assertNotNull(value);
    }
}
