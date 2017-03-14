package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.ReportItem;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemService;
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
    @RequestMapping(value = "/reportItems/{reportItemId}", method = RequestMethod.DELETE)
    public BaseResponse deleteReportItem(@PathVariable("reportItemId") Integer reportItemId) {
        reportItemService.deleteByReportItemId(reportItemId);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

}
