package com.cmcc.ms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.IdcWeek;
import com.cmcc.ms.entity.datashow.IdcWeekExample;


/**
 * The Interface IdcWeekMapper.
 */
public interface IdcWeekMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(IdcWeekExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(IdcWeekExample example);

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
    int insert(IdcWeek record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(IdcWeek record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<IdcWeek> selectByExample(IdcWeekExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the idc week
     */
    IdcWeek selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") IdcWeek record,
                                 @Param("example") IdcWeekExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") IdcWeek record, @Param("example") IdcWeekExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(IdcWeek record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(IdcWeek record);

    /**
     * Find IDC by time.
     *
     * @param date the date
     * @return the list
     */
    List<IdcWeek> findIDCByTime(Date date);
}
