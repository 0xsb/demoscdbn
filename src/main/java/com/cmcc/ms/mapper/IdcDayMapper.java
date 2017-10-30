package com.cmcc.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.IdcDay;
import com.cmcc.ms.entity.datashow.IdcDayExample;


/**
 * The Interface IdcDayMapper.
 */
public interface IdcDayMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(IdcDayExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(IdcDayExample example);

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
    int insert(IdcDay record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(IdcDay record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<IdcDay> selectByExample(IdcDayExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the idc day
     */
    IdcDay selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") IdcDay record,
                                 @Param("example") IdcDayExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") IdcDay record, @Param("example") IdcDayExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(IdcDay record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(IdcDay record);
}
