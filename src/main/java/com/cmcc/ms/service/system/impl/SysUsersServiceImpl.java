/**
 * @author ldy
 */
package com.cmcc.ms.service.system.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.utils.ColumnToPropertyUtil;
import com.cmcc.ms.common.utils.DateUtils;
import com.cmcc.ms.entity.system.SysRoles;
import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersExample;
import com.cmcc.ms.entity.system.SysUsersExample.Criteria;
import com.cmcc.ms.entity.system.SysUsersManual;
import com.cmcc.ms.mapper.SysRolesMapper;
import com.cmcc.ms.mapper.SysUsersMapper;
import com.cmcc.ms.mapper.SysUsersMapperManual;
import com.cmcc.ms.redis.RedisClientTemplate;
import com.cmcc.ms.service.system.SysUsersService;

/**
 * The Class SysUsersServiceImpl.
 */
@Service
public class SysUsersServiceImpl implements SysUsersService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /** The sys users dao. */
    @Autowired
    private SysUsersMapper sysUsersDao;

    /** The sys roles dao. */
    @Autowired
    private SysRolesMapper sysRolesDao;

    /** The sys users dao manual cmcciw. */
    @SuppressWarnings("unused")
    private SysUsersMapperManual sysUsersDaoManualCmcciw; //Cmcciwms

    /** The sys users dao manual cmcciwms. */
    private SysUsersMapperManual sysUsersDaoManualCmcciwms;//Cmcciw

    /**
     * Sets the sys users dao manual cmcciwms.
     *
     * @param sqlSession the new sys users dao manual cmcciwms
     */
    @Resource(name = "sqlSessionCmcciw")
    //cmcciwms
    public void setSysUsersDaoManualCmcciwms(SqlSession sqlSession) {
        this.sysUsersDaoManualCmcciw = sqlSession.getMapper(SysUsersMapperManual.class);
    }

    /**
     * Sets the sys users dao manual cmcciw.
     *
     * @param sqlSession the new sys users dao manual cmcciw
     */
    @Resource(name = "sqlSessionCmcciwms")
    //cmcciw
    public void setSysUsersDaoManualCmcciw(SqlSession sqlSession) {
        this.sysUsersDaoManualCmcciwms = sqlSession.getMapper(SysUsersMapperManual.class);
    }

    @Autowired
    public RedisClientTemplate redisClientTemplate;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#getSysUsersList(java.util.Map)
     */
    @Override
    public List<SysUsersManual> getSysUsersList(Map<String, String> map) {
        SysUsersExample example = new SysUsersExample();
        List<SysUsersManual> sysUsersList = null;
        example.setOrderByClause("CREATE_DATE DESC");
        example.setOrderByClause("USER_ID DESC");
        if (map.get("pageNum") != null && map.get("pageSize") != null) {
            example.setPageIndex((new Integer(map.get("pageNum")) - 1)
                    * new Integer(map.get("pageSize")));
            example.setPageSize(new Integer(map.get("pageSize")));
        }
        Criteria createCriteria = example.createCriteria();
        //超级管理员不显示
        createCriteria.andUserNameNotEqualTo("systemadmin");
        if (null != map.get("userName")) {
            createCriteria.andUserNameLike("%" + map.get("userName") + "%");
        }
        sysUsersList = sysUsersDaoManualCmcciwms.selectByExample(example);
        return sysUsersList;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#countByExample(java.util.Map)
     */
    @Override
    public Integer countByExample(Map<String, String> map) {
        SysUsersExample example = new SysUsersExample();
        example.setOrderByClause(ColumnToPropertyUtil.propertyToColumn(map.get("sortName")) + " "
                + map.get("sortOrder"));
        SysUsersExample.Criteria criteria = example.createCriteria();
        String beginTime = map.get("beginTime");
        String endTime = map.get("endTime");
        String userName = map.get("userName");
        String roleId = map.get("roleId");
        if (StringUtils.isNotEmpty(beginTime)) {
            criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.parse(beginTime,
                    DateUtils.YMD_DASH));
        }
        if (StringUtils.isNotEmpty(endTime)) {
            criteria.andCreateDateLessThanOrEqualTo(DateUtils.parse(endTime, DateUtils.YMD_DASH));
        }
        if (StringUtils.isNotEmpty(userName)) {
            criteria.andUserNameEqualTo(userName);
        }
        if (StringUtils.isNotEmpty(roleId)) {
            criteria.andRoleIdEqualTo(Integer.valueOf(roleId));
        }
        Integer count = sysUsersDao.countByExample(example);
        return count;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#saveSysUsers(java.util.HashMap)
     */
    @Override
    public boolean saveSysUsers(HashMap<String, String> map) {
        try {

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#selectByPrimaryKey(java.lang.Integer)
     */
    @Override
    public SysUsersManual selectByPrimaryKey(Integer userId) {
        SysUsersManual sysUsers = sysUsersDaoManualCmcciwms.selectByPrimaryKey(userId);
        return sysUsers;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#selectByUserName(java.lang.String)
     */
    @Override
    public SysUsersManual selectByUserName(String userName) {
        SysUsersManual sysUsers = sysUsersDaoManualCmcciwms.selectByUserName(userName);
        return sysUsers;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#updateByPrimaryKeySelective(com.cmcc.ms.entity.system.SysUsers)
     */
    @Override
    public Integer updateByPrimaryKeySelective(SysUsers sysUsers) {
        Integer result = sysUsersDao.updateByPrimaryKeySelective(sysUsers);
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#insert(com.cmcc.ms.entity.system.SysUsers)
     */
    @Override
    public Integer insert(SysUsers sysUsers) {
        Integer result = sysUsersDao.insert(sysUsers);
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#deleteByUserIds(java.lang.String[])
     */
    @Override
    public Integer deleteByUserIds(String[] userIds) {
        Integer result = sysUsersDaoManualCmcciwms.deleteByUserIds(userIds);
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#hasUserByRoleId(java.lang.String[])
     */
    @Override
    public Object[] hasUserByRoleId(String[] roleIds) {
        Object[] obj = new Object[2];
        StringBuffer buf = new StringBuffer();
        boolean flag = false;
        for (String roleId : roleIds) {
            Integer num = sysUsersDaoManualCmcciwms.hasUserByRoleId(Integer.valueOf(roleId));
            if (num > 0) {
                SysRoles sysRoles = sysRolesDao.selectByPrimaryKey(Integer.valueOf(roleId));
                buf.append(flag ? "," : "").append(sysRoles.getRoleName());
                flag = true;
            }
        }
        if (flag) {
            obj[0] = true;
            obj[1] = buf.toString();
            return obj;
        } else {
            obj[0] = false;

        }
        return obj;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysUsersService#usersGetRightByUserIds(java.lang.String[], java.lang.String)
     */
    @Override
    public Integer usersGetRightByUserIds(String[] userIds, String subGroup) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userIds", userIds);
        map.put("subGroup", subGroup);
        return sysUsersDaoManualCmcciwms.usersGetRightByUserIds(map);
    }

    //是否 冻结状态
    /**
     * @param tel
     * @return
     */
    public boolean isFrozenState(String tel) {
        try {
            //当前 手机号的 冻结时间
            String frozenTime = redisClientTemplate.get(tel + "frozenTime");
            if (frozenTime == null) {
                return true;
            }
            //frozenTime  十分钟 自动过期
            log.info("账户" + tel + "的冻结时间:" + frozenTime.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //更新 账户冻结信息（时间、 次数）
    /**
     * @param tel
     */
    public void updateFrozenInfo(String tel) {
        try {
            //当前手机号的错误次数
            String frozenNumber = redisClientTemplate.get(tel + "frozenNumber");
            if (frozenNumber != null) {
                if (Integer.parseInt(frozenNumber) + 1 >= 10) {//错误次数 10次
                    Long nowDate = Calendar.getInstance().getTimeInMillis();
                    //保存 冻结时间
                    redisClientTemplate.setex(tel + "frozenTime", 600, String.valueOf(nowDate));
                    //清空错误次数
                    redisClientTemplate.del(tel + "frozenNumber");
                } else {
                    //错误次数+1
                    redisClientTemplate.incr(tel + "frozenNumber");
                    // redisClientTemplate.setex(tel + "frozenNumber", 600,
                    // String.valueOf(Integer.parseInt(frozenNumber) + 1));
                }
            } else {//错误次数赋值第一次 时间为10分钟
                redisClientTemplate.setex(tel + "frozenNumber", 600, "1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
