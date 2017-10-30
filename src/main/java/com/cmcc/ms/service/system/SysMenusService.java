/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.util.List;

import com.cmcc.ms.entity.system.SysMenus;


/**
 * The Interface SysMenusService.
 */
public interface SysMenusService {

    /**
     * Gets the sys menus list.
     *
     * @return the sys menus list
     */
    List<SysMenus> getSysMenusList();

    /**
     * Gets the menus by role id.
     *
     * @param roleId the role id
     * @return the menus by role id
     */
    List<SysMenus> getMenusByRoleId(int roleId);

    /**
     * Select by primary key.
     *
     * @param menuId the menu id
     * @return the sys menus
     */
    SysMenus selectByPrimaryKey(int menuId);

    /**
     * Gets the menus by type.
     *
     * @param type the type
     * @return the menus by type
     */
    List<SysMenus> getMenusByType(int type);

}
