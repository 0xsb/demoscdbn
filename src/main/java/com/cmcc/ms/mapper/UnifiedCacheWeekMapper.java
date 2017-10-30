package com.cmcc.ms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.UnifiedCacheWeek;
import com.cmcc.ms.entity.datashow.UnifiedCacheWeekExample;


/**
 * The Interface UnifiedCacheWeekMapper.
 */
public interface UnifiedCacheWeekMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(UnifiedCacheWeekExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(UnifiedCacheWeekExample example);

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
    int insert(UnifiedCacheWeek record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(UnifiedCacheWeek record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<UnifiedCacheWeek> selectByExample(UnifiedCacheWeekExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the unified cache week
     */
    UnifiedCacheWeek selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") UnifiedCacheWeek record,
                                 @Param("example") UnifiedCacheWeekExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") UnifiedCacheWeek record,
                        @Param("example") UnifiedCacheWeekExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(UnifiedCacheWeek record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(UnifiedCacheWeek record);

    /**
     * Find U cache by time.
     *
     * @param date the date
     * @return the list
     */
    List<UnifiedCacheWeek> findUCacheByTime(Date date);
}
