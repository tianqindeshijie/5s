package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.model.Photo;
import com.chinamobile.iot.lightapp.mysql.model.PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    long countByExample(PhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int deleteByExample(PhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer photoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int insert(Photo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int insertSelective(Photo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    List<Photo> selectByExample(PhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    Photo selectByPrimaryKey(Integer photoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Photo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table photo
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Photo record);
}