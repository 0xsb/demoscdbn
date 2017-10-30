package com.cmcc.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.UnifiedCacheDay;
import com.cmcc.ms.entity.datashow.UnifiedCacheDayExample;


/**
 * The Interface UnifiedCacheDayMapper.
 */
public interface UnifiedCacheDayMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(UnifiedCacheDayExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(UnifiedCacheDayExample example);

    /**
     * Delete by primary key.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(UnifiedCacheDay record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(UnifiedCacheDay record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<UnifiedCacheDay> selectByExample(UnifiedCacheDayExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the unified cache day
     */
    UnifiedCacheDay selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") UnifiedCacheDay record,
                                 @Param("example") UnifiedCacheDayExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") UnifiedCacheDay record,
                        @Param("example") UnifiedCacheDayExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(UnifiedCacheDay record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(UnifiedCacheDay record);
}
