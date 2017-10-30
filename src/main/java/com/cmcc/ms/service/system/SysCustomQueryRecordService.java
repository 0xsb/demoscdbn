/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.util.List;

import com.cmcc.ms.entity.query.CustomQueryInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;



/**
 * The Interface SysCustomQueryRecordService.
 */
public interface SysCustomQueryRecordService {

    /**
     * Save custom query record.
     *
     * @param customQueryInfo the custom query info
     * @return the int
     */
    // 自定义查询 记录到DB
    public int saveCustomQueryRecord(CustomQueryInfo customQueryInfo);

    /**
     * Gets the all custom query record.
     *
     * @param pb the pb
     * @return the all custom query record
     */
    // 获取自定义查询记录 到前端展示
    public List<CustomQueryInfo> getAllCustomQueryRecord(PageBounds pb);

    /**
     * Gets the custom query record size.
     *
     * @return the custom query record size
     */
    // 获取自定义查询记录的条数
    public int getCustomQueryRecordSize();
}
