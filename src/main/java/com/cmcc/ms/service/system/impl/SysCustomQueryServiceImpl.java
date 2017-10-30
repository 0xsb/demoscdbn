/**
 * @author ldy
 */
package com.cmcc.ms.service.system.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cmcc.ms.mapper.SysCustomQueryMapperManual;
import com.cmcc.ms.service.system.SysCustomQueryService;

/**
 * The Class SysCustomQueryServiceImpl.
 */
@Service
public class SysCustomQueryServiceImpl implements SysCustomQueryService {

    /** The sys custom query mapper manual. */
    private SysCustomQueryMapperManual sysCustomQueryMapperManual;

    /**
     * Sets the sys custom query mapper manual.
     *
     * @param session the new sys custom query mapper manual
     */
    @Resource(name = "sqlSessionCmcciw")
    // cmcciw
    public void setSysCustomQueryMapperManual(SqlSession session) {
        this.sysCustomQueryMapperManual = session.getMapper(SysCustomQueryMapperManual.class);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.SysCustomQueryService#superManagerSelect(java.lang.String)
     */
    @Override
    public LinkedList<LinkedHashMap<String, Object>> superManagerSelect(String sql) {
        // TODO Auto-generated method stub
        return sysCustomQueryMapperManual.superManagerSelect(sql);
    }

}
