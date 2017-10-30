package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datamanager.LocalProvRateExtendDay;
import com.cmcc.ms.entity.datamanager.LocalProvRateExtendDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 
 * @author chenyouchao-yl
 *	2017年10月18日下午5:12:59
 */
public interface LocalProvRateExtendDayMapper {
    /***
     * 
     * @param example
     * @return
     */
    int countByExample(LocalProvRateExtendDayExample example);
    /**
     * 
     * @param example
     * @return
     */
    int deleteByExample(LocalProvRateExtendDayExample example);
    /**
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 
     * @param record
     * @return
     */
    int insert(LocalProvRateExtendDay record);
    /***
     * 
     * @param record
     * @return
     */
    int insertSelective(LocalProvRateExtendDay record);
    /**
     * 
     * @param example
     * @return
     */
    List<LocalProvRateExtendDay> selectByExample(LocalProvRateExtendDayExample example);
    /**
     * 
     * @param id
     * @return
     */
    LocalProvRateExtendDay selectByPrimaryKey(Integer id);
    /**
     * 
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") LocalProvRateExtendDay record, @Param("example") LocalProvRateExtendDayExample example);
    /**
     * 
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") LocalProvRateExtendDay record, @Param("example") LocalProvRateExtendDayExample example);
    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(LocalProvRateExtendDay record);
    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(LocalProvRateExtendDay record);
}