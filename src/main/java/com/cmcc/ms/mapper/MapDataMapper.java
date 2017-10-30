package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.MapData;
import com.cmcc.ms.entity.datashow.MapDataExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * The Interface MapDataMapper.
 */
public interface MapDataMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(MapDataExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(MapDataExample example);

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
    int insert(MapData record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(MapData record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<MapData> selectByExample(MapDataExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the map data
     */
    MapData selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") MapData record,
                                 @Param("example") MapDataExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") MapData record, @Param("example") MapDataExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(MapData record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(MapData record);

    /**
     * Select max createtime.
     *
     * @return the date
     */
    Date selectMaxCreatetime();

    /**
     * Find map data by time.
     *
     * @param date the date
     * @return the list
     */
    List<MapData> findMapDataByTime(Date date);

}
