package com.cmcc.ms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.ProvinceOttWeek;
import com.cmcc.ms.entity.datashow.ProvinceOttWeekExample;


/**
 * The Interface ProvinceOttWeekMapper.
 */
public interface ProvinceOttWeekMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(ProvinceOttWeekExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(ProvinceOttWeekExample example);

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
    int insert(ProvinceOttWeek record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(ProvinceOttWeek record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<ProvinceOttWeek> selectByExample(ProvinceOttWeekExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the province ott week
     */
    ProvinceOttWeek selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") ProvinceOttWeek record,
                                 @Param("example") ProvinceOttWeekExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") ProvinceOttWeek record,
                        @Param("example") ProvinceOttWeekExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(ProvinceOttWeek record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(ProvinceOttWeek record);

    /**
     * Find OTT by time.
     *
     * @param date the date
     * @return the list
     */
    List<ProvinceOttWeek> findOTTByTime(Date date);
}
