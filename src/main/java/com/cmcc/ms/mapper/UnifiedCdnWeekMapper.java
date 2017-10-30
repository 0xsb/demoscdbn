package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.UnifiedCdnWeek;
import com.cmcc.ms.entity.datashow.UnifiedCdnWeekExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * The Interface UnifiedCdnWeekMapper.
 */
public interface UnifiedCdnWeekMapper {

    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(UnifiedCdnWeekExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(UnifiedCdnWeekExample example);

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
    int insert(UnifiedCdnWeek record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(UnifiedCdnWeek record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<UnifiedCdnWeek> selectByExample(UnifiedCdnWeekExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the unified cdn week
     */
    UnifiedCdnWeek selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") UnifiedCdnWeek record,
                                 @Param("example") UnifiedCdnWeekExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") UnifiedCdnWeek record,
                        @Param("example") UnifiedCdnWeekExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(UnifiedCdnWeek record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(UnifiedCdnWeek record);

    /**
     * Select max createtime.
     *
     * @return the date
     */
    Date selectMaxCreatetime();

    /**
     * Find CDN by time.
     *
     * @param date the date
     * @return the list
     */
    List<UnifiedCdnWeek> findCDNByTime(Date date);
}
