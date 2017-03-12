package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.model.RegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    long countByExample(RegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int deleteByExample(RegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer regionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int insert(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int insertSelective(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    List<Region> selectByExample(RegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    Region selectByPrimaryKey(Integer regionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Region record);
}