/**
 * @author ldy
 */
package com.cmcc.ms.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cmcc.ms.entity.query.CustomQueryInfo;
import com.cmcc.ms.mapper.CustomQueryInfoMapper;
import com.cmcc.ms.service.system.SysCustomQueryRecordService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Class SysCustomQueryRecordServiceImpl.
 */
@Service
public class SysCustomQueryRecordServiceImpl implements SysCustomQueryRecordService {

    /** The custom query info mapper. */
    private CustomQueryInfoMapper customQueryInfoMapper;

    /**
     * Sets the custom query info mapper.
     *
     * @param session the new custom query info mapper
     */
    @Resource(name = "sqlSessionCmcciwms")
    // cmcciwms
    public void setCustomQueryInfoMapper(SqlSession session) {
        this.customQueryInfoMapper = session.getMapper(CustomQueryInfoMapper.class);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.SysCustomQueryRecordService#saveCustomQueryRecord(com.cmcc.hy.opp.cmcciw.entity.CustomQueryInfo)
     */
    @Override
    public int saveCustomQueryRecord(CustomQueryInfo customQueryInfo) {
        return customQueryInfoMapper.insert(customQueryInfo);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.SysCustomQueryRecordService#getAllCustomQueryRecord(com.github.miemiedev.mybatis.paginator.domain.PageBounds)
     */
    @Override
    public List<CustomQueryInfo> getAllCustomQueryRecord(PageBounds pb) {
        return customQueryInfoMapper.selectForCustomQueryShow(pb);
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.service.system.SysCustomQueryRecordService#getCustomQueryRecordSize()
     */
    @Override
    public int getCustomQueryRecordSize() {

        return customQueryInfoMapper.getCustomQuerySize();
    }

}
