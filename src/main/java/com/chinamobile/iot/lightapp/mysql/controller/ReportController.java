package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.security.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.dto.AddReportRequest;
import com.chinamobile.iot.lightapp.mysql.model.Report;
import com.chinamobile.iot.lightapp.mysql.request.UpdateApplyRequest;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.ReportService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController
@RequestMapping("/mysql")
@Api("模板管理")
public class ReportController {
    private static Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private ReportService reportService;

    /**
     * 根据指定reportId查询模板信息
     *
     * @param reportId the report id
     * @return the report by report id
     */
    @RequestMapping(path = "/reports/{reportId}", method = RequestMethod.GET)
    public Report getReportByReportId(@PathVariable("reportId") Integer reportId) {
        return reportService.findReportByReportId(reportId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param reportName the report name
     * @param cycleId    the cycle id
     * @param regionId   the region id
     * @param periodId   the period id
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the reports
     */
    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public PageInfo<Report> getReports(@RequestParam(value = "reportName", required = false) String reportName,
                                       @RequestParam(value = "cycleId", required = false) Integer cycleId,
                                       @RequestParam(value = "regionId", required = false) Integer regionId,
                                       @RequestParam(value = "periodId", required = false) Integer periodId,
                                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        Report report = new Report();
        report.setReportName(reportName);
        report.setCycleId(cycleId);
        report.setRegionId(regionId);
        report.setPeriodId(periodId);
        return reportService.findReports(report, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param addReportRequest the add report request
     * @return the integer
     */
    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public BaseResponse addReport(@RequestBody AddReportRequest addReportRequest) {
        Report report = new Report();
        BeanUtils.copyProperties(addReportRequest, report);
        Integer userId = SecurityUtils.getCurrentUserId();
        report.setUserId(userId);
        reportService.insert(report);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新模板信息.
     *
     * @param updateApplyRequest the update apply request
     * @return the integer
     */
    @RequestMapping(value = "/reports", method = RequestMethod.PUT)
    public BaseResponse updateReport(@RequestBody UpdateApplyRequest updateApplyRequest) {
        Report report = new Report();
        BeanUtils.copyProperties(updateApplyRequest, report);
        reportService.updateByReportId(report);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的reportId删除模板信息
     *
     * @param reportId the report id
     * @return the integer
     */
    @RequestMapping(value = "/reports/{reportId}", method = RequestMethod.DELETE)
    public BaseResponse deleteReport(@PathVariable("reportId") Integer reportId) {
        reportService.deleteByReportId(reportId);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        return response;
    }

}
