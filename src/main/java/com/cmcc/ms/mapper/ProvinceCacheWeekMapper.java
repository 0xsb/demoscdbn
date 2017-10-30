package com.cmcc.ms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.ProvinceCacheWeek;
import com.cmcc.ms.entity.datashow.ProvinceCacheWeekExample;


/**
 * The Interface ProvinceCacheWeekMapper.
 */
public interface ProvinceCacheWeekMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(ProvinceCacheWeekExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(ProvinceCacheWeekExample example);

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
    int insert(ProvinceCacheWeek record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(ProvinceCacheWeek record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<ProvinceCacheWeek> selectByExample(ProvinceCacheWeekExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the province cache week
     */
    ProvinceCacheWeek selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") ProvinceCacheWeek record,
                                 @Param("example") ProvinceCacheWeekExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") ProvinceCacheWeek record,
                        @Param("example") ProvinceCacheWeekExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(ProvinceCacheWeek record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(ProvinceCacheWeek record);

    /**
     * Find P cache by time.
     *
     * @param date the date
     * @return the list
     */
    List<ProvinceCacheWeek> findPCacheByTime(Date date);
}
