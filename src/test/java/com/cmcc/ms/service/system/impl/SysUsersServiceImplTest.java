package com.cmcc.ms.service.system.impl;

import java.text.SimpleDateFormat;
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
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.BaseTestCase;

/**
 * @author zhangxu-ws
 */
public class SysUsersServiceImplTest extends BaseTestCase {

    @Autowired
    private SysUsersServiceImpl sysUsersServiceImpl;
    @Autowired
    public RedisClientTemplate redisClientTemplate;
    /**
     * Run the SysUsersServiceImpl() constructor test.
     *
     */
    @Test
    public void countByExampleTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stime = sdf.format(date);
        map.put("userName", "ldyldy");
        map.put("roleId", String.valueOf(2));
        map.put("beginTime", "2010-01-01");
        map.put("endTime", stime);
        Integer value = sysUsersServiceImpl.countByExample(map);
        Assert.assertTrue(value > 0);
    }

    /**
     * 
     * @throws Exception
     */

    @Test
    @Rollback
    public void deleteByUserIdsTest() throws Exception {
        String[] stv = new String[5];
        sysUsersServiceImpl.deleteByUserIds(stv);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    @Rollback
    public void getSysUsersListTest() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", "ldyldy");
        map.put("roleId", String.valueOf(2));
        map.put("pageNum", "1");
        map.put("pageSize", "50");
        List<SysUsersManual> list = sysUsersServiceImpl.getSysUsersList(map);
        Assert.assertTrue(list.size() > 0);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    @Rollback
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
        Integer value = sysUsersServiceImpl.insert(sysUsers);
        Assert.assertTrue(value > 0);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    @Rollback
    public void isFrozenStateTest() throws Exception {
        String tel = "15901484089";
        String frozenTime = redisClientTemplate.get(tel + "frozenTime");
        if (frozenTime==null) {
            redisClientTemplate.set(tel+"frozenTime", "1");
        }
        sysUsersServiceImpl.isFrozenState(tel);
    }
    /**
     * 
     * @throws Exception
     */
    @Test
    public void selectByPrimaryKeyTest() throws Exception {
        SysUsersManual sysUsersManual = sysUsersServiceImpl.selectByPrimaryKey(2);
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
        sysUsersServiceImpl.updateByPrimaryKeySelective(sysUsers);

    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void selectByUserNameTest() throws Exception {
        String userName = "ldyldy";
        sysUsersServiceImpl.selectByUserName(userName);

    }
    /**
     * 
     * @throws Exception
     */
    @Rollback
    @Test
    public void hasUserByRoleIdTest() throws Exception {
        String[] roleIds=new String[]{"1","2"};
        Object[] nums = sysUsersServiceImpl.hasUserByRoleId(roleIds);
        Assert.assertTrue(nums.length>0);
    }
    /**
     * @throws Exception
     */
    @Rollback
    @Test
    public void usersGetRightByUserIdsTest() throws Exception{
        String[] userIds=new String[]{"2","581"};
        String subGroup="2";
        Integer num = sysUsersServiceImpl.usersGetRightByUserIds(userIds, subGroup);
        Assert.assertTrue(num>0);
    }
    /**
     * @throws Exception
     */
    @Rollback
    @Test
    public void updateFrozenInfoTest() throws Exception{
        String tel="13691363167";
        sysUsersServiceImpl.updateFrozenInfo(tel);
    }
}
