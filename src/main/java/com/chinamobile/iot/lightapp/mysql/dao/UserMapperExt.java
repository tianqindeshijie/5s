package com.chinamobile.iot.lightapp.mysql.dao;

import com.chinamobile.iot.lightapp.mysql.dto.WorkCycleUserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperExt {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    List<WorkCycleUserDTO> selectByWorkcycleId(@Param("workcycleId") Integer workcycleId);
}