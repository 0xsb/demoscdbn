package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datamanager.LocalProvRate;
import com.cmcc.ms.entity.datamanager.LocalProvRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
// TODO: Auto-generated Javadoc

/**
 * The Interface LocalProvRateMapper.
 *
 * @author chenyouchao-yl
 * 	2017年10月18日下午5:15:41
 */
public interface LocalProvRateMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(LocalProvRateExample example);
    
    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(LocalProvRateExample example);

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
    int insert(LocalProvRate record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(LocalProvRate record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<LocalProvRate> selectByExample(LocalProvRateExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the local prov rate
     */
    LocalProvRate selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") LocalProvRate record, @Param("example") LocalProvRateExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") LocalProvRate record, @Param("example") LocalProvRateExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(LocalProvRate record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(LocalProvRate record);
}