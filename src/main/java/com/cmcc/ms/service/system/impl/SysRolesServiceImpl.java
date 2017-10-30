/**
 * 
 */
package com.cmcc.ms.service.system.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.utils.ColumnToPropertyUtil;
import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.entity.system.SysRoles;
import com.cmcc.ms.entity.system.SysRolesExample;
import com.cmcc.ms.entity.system.SysRolesManual;
import com.cmcc.ms.mapper.SysMenusMapper;
import com.cmcc.ms.mapper.SysRolesMapper;
import com.cmcc.ms.mapper.SysRolesMapperManual;
import com.cmcc.ms.service.system.SysRolesService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Class SysRolesServiceImpl.
 *
 * @author ldy
 */
@Service
public class SysRolesServiceImpl implements SysRolesService {
    
    /** The sys roles dao. */
    @Autowired
    private SysRolesMapper sysRolesDao;
    
    /** The sys roles dao manual. */
    @Autowired
    private SysRolesMapperManual sysRolesDaoManual;
    
    /** The sys menus dao. */
    @Autowired
    private SysMenusMapper sysMenusDao;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#getSysRolesList(java.util.Map, com.github.miemiedev.mybatis.paginator.domain.PageBounds)
     */
    @Override
    public List<SysRolesManual> getSysRolesList(Map<String, Object> map, PageBounds pb) {
        SysRolesExample example = new SysRolesExample();
        example.setOrderByClause("ROLE_ID DESC");
        List<SysRolesManual> sysRolesList = sysRolesDaoManual.selectByExampleForView(example, pb);
        return sysRolesList;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#countByExample(java.util.Map)
     */
    @Override
    public Integer countByExample(Map<String, String> map) {
        SysRolesExample example = new SysRolesExample();
        example.setOrderByClause(ColumnToPropertyUtil.propertyToColumn(map.get("sortName")) + " "
                + map.get("sortOrder"));
        Integer count = sysRolesDao.countByExample(example);
        return count;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#updatePrivilege(java.lang.Integer, java.lang.String[])
     */
    @Override
    public boolean updatePrivilege(Integer roleId, String[] menuId) {
        SysRolesManual sysRoles = sysRolesDaoManual.selectByPrimaryKey(roleId);
        if (sysRoles != null) {
            Set<SysMenus> sysMenus = new HashSet<SysMenus>();

            if (menuId != null) {
                String[] idArray = null;
                // String temp = "0";
                for (int i = 0; i < menuId.length; i++) {
                    idArray = menuId[i].split("_"); // 以"_"拆分menuId和parentId
                    SysMenus menu = sysMenusDao.selectByPrimaryKey(Integer.valueOf(idArray[0]));
                    sysMenus.add(menu);
                }
            } else {
                sysMenus = null;
            }
            sysRolesDaoManual.deleteRelationByRoleId(roleId);
            // 超级管理员特殊处理
            if (roleId == 1) {
                for (int i = 0; i < 8; i++) {
                    SysMenus sysMenusSys = new SysMenus();
                    sysMenusSys.setMenuId(i + 1);
                    sysMenus.add(sysMenusSys);
                }
            }
            if (sysMenus != null) {
                List<SysMenus> list = new ArrayList<SysMenus>(sysMenus);
                sysRoles.setSysMenus(list);
                sysRolesDaoManual.addRoleMenu(sysRoles);
            }

            return true;
        } else {
            return false;
        }

    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#selectByPrimaryKey(java.lang.Integer)
     */
    @Override
    public SysRolesManual selectByPrimaryKey(Integer roleId) {

        SysRolesManual sysRoles = sysRolesDaoManual.selectByPrimaryKey(roleId);
        return sysRoles;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#updateByPrimaryKeySelective(com.cmcc.ms.entity.system.SysRoles)
     */
    @Override
    public Integer updateByPrimaryKeySelective(SysRoles sysRoles) {
        Integer result = sysRolesDao.updateByPrimaryKeySelective(sysRoles);
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#insert(com.cmcc.ms.entity.system.SysRoles)
     */
    @Override
    public Integer insert(SysRoles sysRoles) {
        Integer result = sysRolesDao.insert(sysRoles);
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#deleteByRoleIds(java.lang.String[])
     */
    @Override
    public Integer deleteByRoleIds(String[] roleIds) {
        Integer result = sysRolesDaoManual.deleteByRoleIds(roleIds);
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysRolesService#deleteRelationByRoleId(java.lang.Integer)
     */
    @Override
    public Integer deleteRelationByRoleId(Integer roleId) {
        Integer result = sysRolesDaoManual.deleteRelationByRoleId(roleId);
        return result;
    }

}
