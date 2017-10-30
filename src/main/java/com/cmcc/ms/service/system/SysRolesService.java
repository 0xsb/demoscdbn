/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.util.List;
import java.util.Map;

import com.cmcc.ms.entity.system.SysRoles;
import com.cmcc.ms.entity.system.SysRolesManual;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;



/**
 * The Interface SysRolesService.
 */
public interface SysRolesService {

    /**
     * Select by primary key.
     *
     * @param roleId the role id
     * @return the sys roles manual
     */
    SysRolesManual selectByPrimaryKey(Integer roleId);

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
     * @param sysRoles the sys roles
     * @return the integer
     */
    Integer updateByPrimaryKeySelective(SysRoles sysRoles);

    /**
     * Insert.
     *
     * @param sysRoles the sys roles
     * @return the integer
     */
    Integer insert(SysRoles sysRoles);

    /**
     * Delete by role ids.
     *
     * @param roleIds the role ids
     * @return the integer
     */
    Integer deleteByRoleIds(String[] roleIds);

    /**
     * Delete relation by role id.
     *
     * @param roleId the role id
     * @return the integer
     */
    Integer deleteRelationByRoleId(Integer roleId);

    /**
     * Update privilege.
     *
     * @param roleId the role id
     * @param menuId the menu id
     * @return true, if successful
     */
    boolean updatePrivilege(Integer roleId, String[] menuId);

    /**
     * Gets the sys roles list.
     *
     * @param map the map
     * @param pb the pb
     * @return the sys roles list
     */
    List<SysRolesManual> getSysRolesList(Map<String, Object> map, PageBounds pb);
}
