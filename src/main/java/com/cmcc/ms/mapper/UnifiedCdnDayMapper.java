package com.cmcc.ms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.datashow.UnifiedCdnDay;
import com.cmcc.ms.entity.datashow.UnifiedCdnDayExample;


/**
 * The Interface UnifiedCdnDayMapper.
 */
public interface UnifiedCdnDayMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(UnifiedCdnDayExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(UnifiedCdnDayExample example);

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
    int insert(UnifiedCdnDay record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(UnifiedCdnDay record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<UnifiedCdnDay> selectByExample(UnifiedCdnDayExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the unified cdn day
     */
    UnifiedCdnDay selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") UnifiedCdnDay record,
                                 @Param("example") UnifiedCdnDayExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") UnifiedCdnDay record,
                        @Param("example") UnifiedCdnDayExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(UnifiedCdnDay record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(UnifiedCdnDay record);

    /**
     * Select max createtime.
     *
     * @return the date
     */
    Date selectMaxCreatetime();
}
