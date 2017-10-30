/**
 * @author ldy
 */
package com.cmcc.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cmcc.ms.entity.query.AdminHistoryData;
import com.cmcc.ms.entity.query.AdminHistoryDataExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * The Interface AdminHistoryDataMapper.
 *
 * @author ldy
 */
public interface AdminHistoryDataMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int countByExample(AdminHistoryDataExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int deleteByExample(AdminHistoryDataExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param id the id
     * @return the int
     * @mbggenerated 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int insert(AdminHistoryData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int insertSelective(AdminHistoryData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param example the example
     * @param pb the pb
     * @return the list
     * @mbggenerated 
     */
    List<AdminHistoryData> selectByExample(AdminHistoryDataExample example, PageBounds pb);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param id the id
     * @return the admin history data
     * @mbggenerated 
     */
    AdminHistoryData selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param record the record
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int updateByExampleSelective(@Param("record") AdminHistoryData record,
                                 @Param("example") AdminHistoryDataExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param record the record
     * @param example the example
     * @return the int
     * @mbggenerated 
     */
    int updateByExample(@Param("record") AdminHistoryData record,
                        @Param("example") AdminHistoryDataExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int updateByPrimaryKeySelective(AdminHistoryData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table admin_history_data
     *
     * @param record the record
     * @return the int
     * @mbggenerated 
     */
    int updateByPrimaryKey(AdminHistoryData record);
}