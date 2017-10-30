/**
 * 
 */
package com.cmcc.ms.service.system;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author chenyouchao-yl
 *
 */
public class SysMenusServiceTest extends BaseTestCase {

    @Autowired
    private SysMenusService sysMenusService;

    /**
     * Run the List<SysMenus> getMenusByRoleId(int) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void getMenusByRoleIdTest() {
        List<SysMenus> list = sysMenusService.getMenusByRoleId(1);
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
        List<SysMenus> list = sysMenusService.getMenusByType(-200);
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
        List<SysMenus> list = sysMenusService.getSysMenusList();
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
        SysMenus value = sysMenusService.selectByPrimaryKey(1);
        Assert.assertNotNull(value);
    }

}
