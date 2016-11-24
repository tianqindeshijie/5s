package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.model.Photos;
import com.chinamobile.iot.lightapp.mysql.model.PhotosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotosMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    long countByExample(PhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int deleteByExample(PhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer photoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int insert(Photos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int insertSelective(Photos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    List<Photos> selectByExample(PhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    Photos selectByPrimaryKey(Integer photoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Photos record, @Param("example") PhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Photos record, @Param("example") PhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Photos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photos
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Photos record);
}