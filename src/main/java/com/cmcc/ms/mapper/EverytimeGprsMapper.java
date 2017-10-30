package com.cmcc.ms.mapper;

import com.cmcc.ms.entity.datashow.EverytimeGprs;
import com.cmcc.ms.entity.datashow.EverytimeGprsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * The Interface EverytimeGprsMapper.
 */
public interface EverytimeGprsMapper {
    
    /**
     * Count by example.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(EverytimeGprsExample example);

    /**
     * Delete by example.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(EverytimeGprsExample example);

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(EverytimeGprs record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(EverytimeGprs record);

    /**
     * Select by example.
     *
     * @param example the example
     * @return the list
     */
    List<EverytimeGprs> selectByExample(EverytimeGprsExample example);

    /**
     * Update by example selective.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") EverytimeGprs record,
                                 @Param("example") EverytimeGprsExample example);

    /**
     * Update by example.
     *
     * @param record the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") EverytimeGprs record,
                        @Param("example") EverytimeGprsExample example);
}
