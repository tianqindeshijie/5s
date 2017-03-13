package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.model.CheckItemScore;
import com.chinamobile.iot.lightapp.mysql.model.CheckItemScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckItemScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    long countByExample(CheckItemScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int deleteByExample(CheckItemScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer checkItemScoreId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int insert(CheckItemScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int insertSelective(CheckItemScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    List<CheckItemScore> selectByExample(CheckItemScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    CheckItemScore selectByPrimaryKey(Integer checkItemScoreId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CheckItemScore record, @Param("example") CheckItemScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CheckItemScore record, @Param("example") CheckItemScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CheckItemScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CheckItemScore record);
}