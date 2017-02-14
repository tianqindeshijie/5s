package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Report;
import com.chinamobile.iot.lightapp.mysql.service.ReportService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * @param reportName    the report name
     * @param reportContent the report content
     * @param reportType    the report type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the reports
     */

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public PageInfo<Report> getReports(@RequestParam(value = "reportName", required = false) String reportName,
                                           @RequestParam(value = "reportContent", required = false) String reportContent,
                                           @RequestParam(value = "reportType", required = false) Integer reportType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Report report = new Report();

        return reportService.findReports(report, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param report the add report request
     * @return the integer
     */
    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public Integer addReport(@RequestBody Report report) {
        return reportService.insert(report);
    }

    /**
     * 更新模板信息.
     *
     * @param report the update report request
     * @return the integer
     */
    @RequestMapping(value = "/reports", method = RequestMethod.PUT)
    public Integer updateReport(@RequestBody Report report) {
        return reportService.updateByReportId(report);
    }

    /**
     * 根据指定的reportId删除模板信息
     *
     * @param reportId the report id
     * @return the integer
     */
    @RequestMapping(value = "/reports/{reportId}", method = RequestMethod.DELETE)
    public Integer deleteReport(@PathVariable("reportId") Integer reportId) {
        return reportService.deleteByReportId(reportId);
    }

}
