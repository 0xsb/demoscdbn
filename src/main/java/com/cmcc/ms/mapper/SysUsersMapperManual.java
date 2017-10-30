/**
 * @author ldy
 */
package com.cmcc.ms.mapper;

import java.util.List;
import java.util.Map;

import com.cmcc.ms.entity.system.SysUsersExample;
import com.cmcc.ms.entity.system.SysUsersManual;


/**
 * The Interface SysUsersMapperManual.
 *
 * @author ldy
 */
public interface SysUsersMapperManual {

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<SysUsersManual> selectByExample(SysUsersExample example);

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
     * Delete by user ids.
     *
     * @param userIds the user ids
     * @return the int
     */
    int deleteByUserIds(String[] userIds);

    /**
     * Checks for user by role id.
     *
     * @param roleId the role id
     * @return the int
     */
    int hasUserByRoleId(Integer roleId);

    /**
     * Update state by user ids.
     *
     * @param userIds the user ids
     * @return the integer
     */
    Integer updateStateByUserIds(String[] userIds);

    /**
     * Users get right by user ids.
     *
     * @param map the map
     * @return the integer
     */
    Integer usersGetRightByUserIds(Map<String, Object> map);

    /**
     * Update last wro time by user.
     *
     * @param sysUsers the sys users
     * @return the integer
     */
    Integer updateLastWroTimeByUser(SysUsersManual sysUsers);

    /**
     * Select cmcciw by user name.
     *
     * @param userName the user name
     * @return the string
     */
    String selectCmcciwByUserName(String userName);
}
