/**
 * @author ldy
 */
package com.cmcc.ms.mapper;

import java.util.List;

import com.cmcc.ms.entity.system.SysRolesExample;
import com.cmcc.ms.entity.system.SysRolesManual;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Interface SysRolesMapperManual.
 *
 * @author ldy
 */
public interface SysRolesMapperManual {

    /**
     * Select by example.
     *
     * @param example the example
     * @param pb the pb
     * @return the list
     */
    List<SysRolesManual> selectByExample(SysRolesExample example, PageBounds pb);

    /**
     * Select by primary key.
     *
     * @param roleId the role id
     * @return the sys roles manual
     */
    SysRolesManual selectByPrimaryKey(Integer roleId);

    /**
     * Adds the role menu.
     *
     * @param record the record
     * @return the int
     */
    int addRoleMenu(SysRolesManual record);

    /**
     * Delete relation by role id.
     *
     * @param roleId the role id
     * @return the int
     */
    int deleteRelationByRoleId(Integer roleId);

    /**
     * Gets the role.
     *
     * @param roleId the role id
     * @return the role
     */
    SysRolesManual getRole(Integer roleId);

    /**
     * Delete by role ids.
     *
     * @param roleIds the role ids
     * @return the int
     */
    int deleteByRoleIds(String[] roleIds);

    /**
     * Select by example for view.
     *
     * @param example the example
     * @param pb the pb
     * @return the list
     */
    List<SysRolesManual> selectByExampleForView(SysRolesExample example, PageBounds pb);
}
