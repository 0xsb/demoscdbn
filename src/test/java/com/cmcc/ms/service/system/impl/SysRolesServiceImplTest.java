package com.cmcc.ms.service.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.system.SysRoles;
import com.cmcc.ms.entity.system.SysRolesManual;
import com.cmcc.ms.service.BaseTestCase;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * @author chenyouchao-yl
 */
public class SysRolesServiceImplTest extends BaseTestCase {
    @Autowired
    private SysRolesServiceImpl sysRolesServiceImpl;

    /**
     * Run the Integer countByExample(Map<String,String>) method test.
     *
     * @throws Exception
     */
    @Test
    public void countByExampleTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sortName", "1");
        Integer value = sysRolesServiceImpl.countByExample(map);
        Assert.assertTrue(value > 0);
    }

    /**
     * Run the Integer insert(SysRoles) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void insertTest() throws Exception {
        SysRoles sysRoles = new SysRoles();
        sysRoles.setRoleId(2);
        sysRoles.setRoleName("全国权限");
        sysRoles.setCreateDate(new Date());
        sysRoles.setRoleDesc("测试");
        Integer value = sysRolesServiceImpl.insert(sysRoles);
        Assert.assertTrue(value > 0);
    }

    /**
     * Run the Integer insert(SysRoles) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void updateByPrimaryKeySelectiveTest() throws Exception {
        SysRoles sysRoles = new SysRoles();
        sysRoles.setRoleId(372);
        sysRoles.setRoleName("test");
        sysRoles.setCreateDate(new Date());
        sysRoles.setRoleDesc("测试");
        Integer value = sysRolesServiceImpl.updateByPrimaryKeySelective(sysRoles);
        Assert.assertTrue(value > 0);
    }

    /**
     * Run the List<SysRolesManual> getSysRolesList(Map<String, Object> map, PageBounds pb) method test.
     *
     * @throws Exception
     */
    @Test
    public void getSysRolesListTest() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("roleName", "test");
        PageBounds pb = new PageBounds(1, 15);
        List<SysRolesManual> list = sysRolesServiceImpl.getSysRolesList(map, pb);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * Run the List<SysRolesManual> getSysRolesList(Map<String, Object> map, PageBounds pb) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void deleteRelationByRoleIdTest() throws Exception {
        Integer value = sysRolesServiceImpl.deleteRelationByRoleId(2);
        Assert.assertTrue(value > 0);
    }

    /**
     * Run the SysRolesManual selectByPrimaryKey(Integer ) method test.
     *
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKeyTest() throws Exception {
        SysRolesManual sysRolesManual = sysRolesServiceImpl.selectByPrimaryKey(2);
        Assert.assertNotNull(sysRolesManual);
    }

    /**
     * Run the boolean updatePrivilege(Integer roleId, String[] menuId ) method test.
     *
     * @throws Exception
     */
    @Test
    @Rollback
    public void updatePrivilegeTest() throws Exception {
        String[] menuId = new String[] { "1", "2", "3" };
        boolean flg = sysRolesServiceImpl.updatePrivilege(2, menuId);
        Assert.assertTrue(flg);
    }
}
