package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.PeriodDTO;
import com.chinamobile.iot.lightapp.mysql.model.Period;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.PeriodService;
import com.chinamobile.iot.security.SecurityUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController

@Api("时间段管理")
public class PeriodController {
    private static Logger logger = LoggerFactory.getLogger(PeriodController.class);
    @Autowired
    private PeriodService periodService;

    /**
     * 根据指定periodId查询时间段信息
     *
     * @param periodId the period id
     * @return the period by period id
     */
    @ApiOperation(value = "查询时间段", notes = "查询时间段")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "periodId", required = true, value = "时间段ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/periods/{periodId}", method = RequestMethod.GET)
    public Period getPeriodByPeriodId(@PathVariable("periodId") Integer periodId) {
        return periodService.findPeriodByPeriodId(periodId);
    }

    /**
     * 根据指定参数查询时间段信息列表
     *
     * @param periodName the period name
     * @param cycleId    the cycle id
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the periods
     */
    @ApiOperation(value = "查询时间段列表", notes = "查询时间段列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "periodName", value = "时间段名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "cycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/periods", method = RequestMethod.GET)
    public BaseResponse getPeriods(@RequestParam(value = "periodName", required = false) String periodName,
                                   @RequestParam(value = "cycleId", required = false) Integer cycleId,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        Integer userId = SecurityUtils.getCurrentUserId();
        Period period = new Period();
        period.setPeriodName(periodName);
        period.setCycleId(cycleId);
        PageInfo<PeriodDTO> pageInfo = periodService.findPeriods(period, userId, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增时间段信息.
     *
     * @param period the add period request
     * @return the integer
     */
    @ApiOperation(value = "新增时间段", notes = "新增时间段")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/periods", method = RequestMethod.POST)
    public BaseResponse addPeriod(@RequestBody Period period) {
        Integer periodId = periodService.insert(period);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(Collections.singletonMap("periodId", periodId));
        return response;
    }

    /**
     * 更新时间段信息.
     *
     * @param period the update period request
     * @return the integer
     */
    @ApiOperation(value = "更新时间段", notes = "更新时间段")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/periods", method = RequestMethod.PUT)
    public BaseResponse updatePeriod(@RequestBody Period period) {
        periodService.updateByPeriodId(period);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 根据指定的periodId删除时间段信息
     *
     * @param periodId the period id
     * @return the integer
     */
    @ApiOperation(value = "删除时间段", notes = "删除时间段")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "periodId", required = true, value = "时间段ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/periods/{periodId}", method = RequestMethod.DELETE)
    public BaseResponse deletePeriod(@PathVariable("periodId") Integer periodId) {
        periodService.deleteByPeriodId(periodId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

}
