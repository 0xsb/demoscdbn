package com.cmcc.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.ProvinceOttDay;
import com.cmcc.ms.entity.datashow.ProvinceOttDayExample;


/**
 * The Interface ProvinceOttDayMapper.
 */
public interface ProvinceOttDayMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(ProvinceOttDayExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(ProvinceOttDayExample example);

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
    int insert(ProvinceOttDay record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(ProvinceOttDay record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<ProvinceOttDay> selectByExample(ProvinceOttDayExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the province ott day
     */
    ProvinceOttDay selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") ProvinceOttDay record,
                                 @Param("example") ProvinceOttDayExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") ProvinceOttDay record,
                        @Param("example") ProvinceOttDayExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(ProvinceOttDay record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(ProvinceOttDay record);
}
