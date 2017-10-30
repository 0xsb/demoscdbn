/**
 * @author ldy
 */
package com.cmcc.ms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.entity.system.OperateLogExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Interface OperateLogMapper.
 *
 * @author ldy
 */
public interface OperateLogMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int countByExample(OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int deleteByExample(OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param id the id
     * @return the int
     * @mbggenerated 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int insert(OperateLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int insertSelective(OperateLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param example the example
     * @return the list
     * @mbggenerated 
     */
    List<OperateLog> selectByExampleWithBLOBs(OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param example the example
     * @return the list
     * @mbggenerated 
     */
    List<OperateLog> selectByExample(OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param id the id
     * @return the operate log
     * @mbggenerated 
     */
    OperateLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int updateByExampleSelective(@Param("record") OperateLog record,
                                 @Param("example") OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int updateByExampleWithBLOBs(@Param("record") OperateLog record,
                                 @Param("example") OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int updateByExample(@Param("record") OperateLog record,
                        @Param("example") OperateLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int updateByPrimaryKeySelective(OperateLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int updateByPrimaryKeyWithBLOBs(OperateLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table operate_log
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int updateByPrimaryKey(OperateLog record);

    /**
     *  模糊查询.
     *
     * @param map the map
     * @param pb the pb
     * @return the list
     */
    List<OperateLog> fuzzyQueryOperateLogListByName(Map<String, Object> map, PageBounds pb);

    /**
     *  模糊查询的总记录数.
     *
     * @param map the map
     * @return the fuzzy query size
     */
    int getFuzzyQuerySize(Map<String, Object> map);

}