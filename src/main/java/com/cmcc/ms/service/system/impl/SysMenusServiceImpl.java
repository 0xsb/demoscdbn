 /**
 * 
 */
package com.cmcc.ms.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.entity.system.SysMenusExample;
import com.cmcc.ms.mapper.SysMenusMapper;
import com.cmcc.ms.mapper.SysMenusMapperManual;
import com.cmcc.ms.service.system.SysMenusService;


/**
 * The Class SysMenusServiceImpl.
 */
@Service
public class SysMenusServiceImpl implements SysMenusService {
    
    /** The sys menus dao. */
    @Autowired
    private SysMenusMapper sysMenusDao;
    
    /** The sys menus dao manual. */
    @Autowired
    private SysMenusMapperManual sysMenusDaoManual;

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysMenusService#getSysMenusList()
     */
    @Override
    public List<SysMenus> getSysMenusList() {
        SysMenusExample example = new SysMenusExample();
        List<SysMenus> sysMenusList = sysMenusDao.selectByExample(example);
        return sysMenusList;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysMenusService#getMenusByRoleId(int)
     */
    @Override
    public List<SysMenus> getMenusByRoleId(int roleId) {
        List<SysMenus> sysMenus = sysMenusDaoManual.getMenusByRoleId(roleId);
        return sysMenus;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysMenusService#selectByPrimaryKey(int)
     */
    @Override
    public SysMenus selectByPrimaryKey(int menuId) {
        SysMenus sysMenus = sysMenusDao.selectByPrimaryKey(menuId);
        return sysMenus;
    }

    /* (non-Javadoc)
     * @see com.cmcc.ms.service.system.SysMenusService#getMenusByType(int)
     */
    @Override
    public List<SysMenus> getMenusByType(int type) {
        return sysMenusDaoManual.getMenusByType(type);
    }

}
