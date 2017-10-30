/**
 * @author ldy
 */
package com.cmcc.ms.mapper;

import java.util.List;

import com.cmcc.ms.entity.system.SysMenus;


/**
 * The Interface SysMenusMapperManual.
 *
 * @author ldy
 */
public interface SysMenusMapperManual {

    /**
     * Gets the menus by role id.
     *
     * @param roleId the role id
     * @return the menus by role id
     */
    List<SysMenus> getMenusByRoleId(int roleId);

    /**
     * Gets the menus by type.
     *
     * @param type the type
     * @return the menus by type
     */
    List<SysMenus> getMenusByType(int type);
}
