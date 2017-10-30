package com.cmcc.ms.service.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersManual;
import com.cmcc.ms.service.BaseTestCase;

/**
 *
 * @generatedBy CodePro at 17-8-30 上午11:51
 * @author zhangxu-ws
 */
public class SysUsersServiceTest extends BaseTestCase {
    @Autowired
    private SysUsersService sysUsersService;

    /**
     * Run the sysUsersService() constructor test.
     *
     */
    @Test
    public void countByExampleTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", "ldyldy");
        map.put("roleId", String.valueOf(2));
        Integer value = sysUsersService.countByExample(map);
        Assert.assertTrue(value > 0);
    }

    /**
     * 
     * @throws Exception
     */

    @Rollback
    @Test
    public void deleteByUserIdsTest() throws Exception {
        String[] stv = new String[5];
        sysUsersService.deleteByUserIds(stv);
    }

    /**
     * 
     * @throws Exception
     */

    @Rollback
    @Test
    public void getSysUsersListTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", "ldyldy");
        map.put("roleId", String.valueOf(2));
        List<SysUsersManual> list = sysUsersService.getSysUsersList(map);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * 
     * @throws Exception
     */
    @Rollback
    @Test
    public void inserTest() throws Exception {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUserName("ldyldy");
        sysUsers.setUserPassword("717f14b5dd8b6c99e5cb4e13c2fbb74b");
        sysUsers.setUserRelname("ldy");
        sysUsers.setRoleId(1);
        sysUsers.setCreateDate(new Date());
        sysUsers.setUserName("测试");
        sysUsers.setCompany("某某公司");
        sysUsers.setEmail("2489270195@qq.com");
        sysUsers.setState("1");
        sysUsers.setWrongcount(525);
        Integer value = sysUsersService.insert(sysUsers);
        Assert.assertTrue(value > 0);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKeyTest() throws Exception {
        SysUsersManual sysUsersManual = sysUsersService.selectByPrimaryKey(2);
        Assert.assertNotNull(sysUsersManual);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    @Rollback
    public void updateByPrimaryKeySelectiveTest() throws Exception {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setUserName("ldyldy");
        sysUsers.setUserRelname("ldy");
        sysUsers.setRoleId(1);
        sysUsers.setCreateDate(new Date());
        sysUsers.setUserName("测试");
        sysUsers.setCompany("某某公司");
        sysUsers.setEmail("2489270195@qq.com");
        sysUsers.setState("1");
        sysUsers.setWrongcount(525);
        sysUsersService.updateByPrimaryKeySelective(sysUsers);

    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void selectByUserNameTest() throws Exception {
        String userName = "ldyldy";
        sysUsersService.selectByUserName(userName);

    }
}
