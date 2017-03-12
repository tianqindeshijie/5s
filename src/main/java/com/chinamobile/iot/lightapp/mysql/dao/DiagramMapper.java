package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.model.Diagram;
import com.chinamobile.iot.lightapp.mysql.model.DiagramExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiagramMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    long countByExample(DiagramExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int deleteByExample(DiagramExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer diagramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int insert(Diagram record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int insertSelective(Diagram record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    List<Diagram> selectByExample(DiagramExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    Diagram selectByPrimaryKey(Integer diagramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Diagram record, @Param("example") DiagramExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Diagram record, @Param("example") DiagramExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Diagram record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table diagram
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Diagram record);
}