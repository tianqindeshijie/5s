package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.dto.CheckItemScoreDTO;
import com.chinamobile.iot.lightapp.mysql.model.CheckItemScoreExample;

import java.util.List;

public interface CheckItemScoreMapperExt {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    List<CheckItemScoreDTO> selectByExample(CheckItemScoreExample example);

}