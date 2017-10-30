/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersManual;



/**
 * The Interface SysUsersService.
 */
public interface SysUsersService {

    /**
     * Gets the sys users list.
     *
     * @param map the map
     * @return the sys users list
     */
    List<SysUsersManual> getSysUsersList(Map<String, String> map);

    /**
     * Save sys users.
     *
     * @param map the map
     * @return true, if successful
     */
    boolean saveSysUsers(HashMap<String, String> map);

    /**
     * Select by primary key.
     *
     * @param userId the user id
     * @return the sys users manual
     */
    SysUsersManual selectByPrimaryKey(Integer userId);

    /**
     * Select by user name.
     *
     * @param userName the user name
     * @return the sys users manual
     */
    SysUsersManual selectByUserName(String userName);

    /**
     * Count by example.
     *
     * @param map the map
     * @return the integer
     */
    Integer countByExample(Map<String, String> map);

    /**
     * Update by primary key selective.
     *
     * @param sysUsers the sys users
     * @return the integer
     */
    Integer updateByPrimaryKeySelective(SysUsers sysUsers);

    /**
     * Insert.
     *
     * @param sysUsers the sys users
     * @return the integer
     */
    Integer insert(SysUsers sysUsers);

    /**
     * Delete by user ids.
     *
     * @param userIds the user ids
     * @return the integer
     */
    Integer deleteByUserIds(String[] userIds);

    /**
     * Checks for user by role id.
     *
     * @param roleIds the role ids
     * @return the object[]
     */
    Object[] hasUserByRoleId(String[] roleIds);

    /**
     * Users get right by user ids.
     *
     * @param userIds the user ids
     * @param subGroup the sub group
     * @return the integer
     */
    Integer usersGetRightByUserIds(String[] userIds, String subGroup);

}
