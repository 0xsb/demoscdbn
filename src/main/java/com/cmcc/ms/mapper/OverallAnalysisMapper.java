package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.OverallAnalysis;
import com.cmcc.ms.entity.datashow.OverallAnalysisExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * The Interface OverallAnalysisMapper.
 */
public interface OverallAnalysisMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(OverallAnalysisExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(OverallAnalysisExample example);

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
    int insert(OverallAnalysis record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(OverallAnalysis record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<OverallAnalysis> selectByExample(OverallAnalysisExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the overall analysis
     */
    OverallAnalysis selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") OverallAnalysis record,
                                 @Param("example") OverallAnalysisExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") OverallAnalysis record,
                        @Param("example") OverallAnalysisExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(OverallAnalysis record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(OverallAnalysis record);
}
