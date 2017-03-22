package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.ReportItem;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("检查大项管理")
public class ReportItemController {
    private static Logger logger = LoggerFactory.getLogger(ReportItemController.class);
    @Autowired
    private ReportItemService reportItemService;

    /**
     * 根据指定reportItemId查询检查大项信息
     *
     * @param reportItemId the reportItem id
     * @return the reportItem by reportItem id
     */
    @ApiOperation(value = "查询检查大项", notes = "查询检查大项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "reportItemId", required = true, value = "检查大项ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/reportItems/{reportItemId}", method = RequestMethod.GET)
    public ReportItem getReportItemByReportItemId(@PathVariable("reportItemId") Integer reportItemId) {
        return reportItemService.findReportItemByReportItemId(reportItemId);
    }

    /**
     * 根据指定参数查询检查大项信息列表
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the reportItems
     */
    @ApiOperation(value = "查询检查大项列表", notes = "查询检查大项列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "cycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItems", method = RequestMethod.GET)
    public BaseResponse getReportItems(@RequestParam(value = "cycleId", required = true) Integer cycleId,
                                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        ReportItem reportItem = new ReportItem();
        reportItem.setCycleId(cycleId);
        PageInfo<ReportItem> pageInfo = reportItemService.findReportItems(reportItem, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增检查大项信息.
     *
     * @param reportItem the add reportItem request
     * @return the integer
     */
    @ApiOperation(value = "新增检查大项", notes = "新增检查大项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItems", method = RequestMethod.POST)
    public BaseResponse addReportItem(@RequestBody ReportItem reportItem) {
        reportItemService.insert(reportItem);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新检查大项信息.
     *
     * @param reportItem the update reportItem request
     * @return the integer
     */
    @ApiOperation(value = "更新检查大项", notes = "更新检查大项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItems", method = RequestMethod.PUT)
    public BaseResponse updateReportItem(@RequestBody ReportItem reportItem) {
        reportItemService.updateByReportItemId(reportItem);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的reportItemId删除检查大项信息
     *
     * @param reportItemId the reportItem id
     * @return the integer
     */
    @ApiOperation(value = "删除检查大项", notes = "删除检查大项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "reportItemId", required = true, value = "检查大项ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItems/{reportItemId}", method = RequestMethod.DELETE)
    public BaseResponse deleteReportItem(@PathVariable("reportItemId") Integer reportItemId) {
        reportItemService.deleteByReportItemId(reportItemId);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

}
