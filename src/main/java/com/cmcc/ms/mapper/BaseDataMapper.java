package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.BaseData;
import com.cmcc.ms.entity.datashow.BaseDataExample;
import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.entity.datashow.OverallAnalysis;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * The Interface BaseDataMapper.
 */
public interface BaseDataMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(BaseDataExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(BaseDataExample example);

    /**
     * Delete by primary key.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(String id);

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(BaseData record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(BaseData record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<BaseData> selectByExample(BaseDataExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the base data
     */
    BaseData selectByPrimaryKey(String id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") BaseData record,
                                 @Param("example") BaseDataExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") BaseData record, @Param("example") BaseDataExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(BaseData record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(BaseData record);

    /**
     * Select overall analysis list.
     *
     * @return the list
     */
    List<OverallAnalysis> selectOverallAnalysisList();

    /**
     * Select business traffic list.
     *
     * @param busBig the bus big
     * @return the list
     */
    List<BusinessTraffic> selectBusinessTrafficList(String busBig);

    /**
     * Select sum trafficin.
     *
     * @param busBig the bus big
     * @return the double
     */
    Double selectSumTrafficin(String busBig);
}
