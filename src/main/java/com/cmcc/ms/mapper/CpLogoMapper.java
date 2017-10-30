package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.CpLogo;
import com.cmcc.ms.entity.datashow.CpLogoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

// TODO: Auto-generated Javadoc
/**
 * The Interface CpLogoMapper.
 */
public interface CpLogoMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(CpLogoExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(CpLogoExample example);

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
    int insert(CpLogo record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(CpLogo record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<CpLogo> selectByExample(CpLogoExample example);

    /**
     * Select by primary key.
     *
     * @param id the id
     * @return the cp logo
     */
    CpLogo selectByPrimaryKey(Integer id);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") CpLogo record, @Param("example") CpLogoExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") CpLogo record, @Param("example") CpLogoExample example);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(CpLogo record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(CpLogo record);
}