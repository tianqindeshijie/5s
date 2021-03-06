package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.AddReportRequest;
import com.chinamobile.iot.lightapp.mysql.model.Report;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.ReportService;
import com.chinamobile.iot.security.SecurityUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController

@Api("报告管理")
public class ReportController {
    private static Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private ReportService reportService;

    /**
     * 根据指定reportId查询报告信息
     *
     * @param reportId the report id
     * @return the report by report id
     */
    @ApiOperation(value = "查询报告", notes = "查询报告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "reportId", required = true, value = "报告ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/reports/{reportId}", method = RequestMethod.GET)
    public BaseResponse getReportByReportId(@PathVariable("reportId") Integer reportId) {
        Report report = reportService.findReportByReportId(reportId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(report);
        return response;
    }

    /**
     * 根据指定参数查询报告信息列表
     *
     * @param reportName the report name
     * @param cycleId    the cycle id
     * @param regionId   the region id
     * @param startTime  the start time
     * @param endTime    the end time
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the reports
     */
    @ApiOperation(value = "查询报告列表", notes = "查询报告列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "reportName", value = "报告名称", dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "cycleId", value = "工作圈ID", dataType = "integer"),
            @ApiImplicitParam(paramType = "query", name = "regionId", value = "区域ID", dataType = "integer"),
            @ApiImplicitParam(paramType = "query", name = "startTime", value = "开始时间", dataType = "dateTime"),
            @ApiImplicitParam(paramType = "query", name = "endTime", value = "工作圈ID", dataType = "dateTime"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "string")})
    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public BaseResponse getReports(@RequestParam(value = "reportName", required = false) String reportName,
                                   @RequestParam(value = "cycleId", required = false) Integer cycleId,
                                   @RequestParam(value = "regionId", required = false) Integer regionId,
                                   @RequestParam(value = "startTime", required = false) Date startTime,
                                   @RequestParam(value = "endTime", required = false) Date endTime,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        Report report = new Report();
        report.setReportName(reportName);
        report.setCycleId(cycleId);
        report.setRegionId(regionId);
        report.setStartTime(startTime);
        report.setEndTime(endTime);
        PageInfo<Report> pageInfo = reportService.findReports(report, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增报告信息.
     *
     * @param addReportRequest the add report request
     * @return the integer
     */
    @ApiOperation(value = "新增报告", notes = "新增报告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public BaseResponse addReport(@RequestBody AddReportRequest addReportRequest) {
        Report report = new Report();
        BeanUtils.copyProperties(addReportRequest, report);
        Integer userId = SecurityUtils.getCurrentUserId();
        report.setUserId(userId);
        Integer reportId = reportService.insert(report);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(Collections.singletonMap("reportId", reportId));
        return response;
    }

    /**
     * 更新报告信息.
     *
     * @param Report the update apply request
     * @return the integer
     */
    @ApiOperation(value = "更新报告", notes = "更新报告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reports", method = RequestMethod.PUT)
    public BaseResponse updateReport(@RequestBody Report Report) {
        Report report = new Report();
        BeanUtils.copyProperties(Report, report);
        reportService.updateByReportId(report);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 根据指定的reportId删除报告信息
     *
     * @param reportId the report id
     * @return the integer
     */
    @ApiOperation(value = "删除报告", notes = "删除报告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "reportId", required = true, value = "报告ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reports/{reportId}", method = RequestMethod.DELETE)
    public BaseResponse deleteReport(@PathVariable("reportId") Integer reportId) {
        reportService.deleteByReportId(reportId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

}
