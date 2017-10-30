package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.BusinessTraffic;
import com.cmcc.ms.entity.datashow.BusinessTrafficExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * The Interface BusinessTrafficMapper.
 */
public interface BusinessTrafficMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(BusinessTrafficExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(BusinessTrafficExample example);

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
    int insert(BusinessTraffic record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(BusinessTraffic record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<BusinessTraffic> selectByExample(BusinessTrafficExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the business traffic
     */
    BusinessTraffic selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") BusinessTraffic record,
                                 @Param("example") BusinessTrafficExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") BusinessTraffic record,
                        @Param("example") BusinessTrafficExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(BusinessTraffic record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(BusinessTraffic record);

}
