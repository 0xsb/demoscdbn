package com.cmcc.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.ProvinceCacheDay;
import com.cmcc.ms.entity.datashow.ProvinceCacheDayExample;


/**
 * The Interface ProvinceCacheDayMapper.
 */
public interface ProvinceCacheDayMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(ProvinceCacheDayExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(ProvinceCacheDayExample example);

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
    int insert(ProvinceCacheDay record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(ProvinceCacheDay record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<ProvinceCacheDay> selectByExample(ProvinceCacheDayExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the province cache day
     */
    ProvinceCacheDay selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") ProvinceCacheDay record,
                                 @Param("example") ProvinceCacheDayExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") ProvinceCacheDay record,
                        @Param("example") ProvinceCacheDayExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(ProvinceCacheDay record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(ProvinceCacheDay record);
}
