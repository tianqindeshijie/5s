package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.ReportItem;
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
@Api("模板管理")
public class ReportItemController {
    private static Logger logger = LoggerFactory.getLogger(ReportItemController.class);
    @Autowired
    private ReportItemService reportItemService;

    /**
     * 根据指定reportItemId查询模板信息
     *
     * @param reportItemId the reportItem id
     * @return the reportItem by reportItem id
     */
    @RequestMapping(path = "/reportItems/{reportItemId}", method = RequestMethod.GET)
    public ReportItem getReportItemByReportItemId(@PathVariable("reportItemId") Integer reportItemId) {
        return reportItemService.findReportItemByReportItemId(reportItemId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param reportItemName    the reportItem name
     * @param reportItemContent the reportItem content
     * @param reportItemType    the reportItem type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the reportItems
     */

    @RequestMapping(value = "/reportItems", method = RequestMethod.GET)
    public PageInfo<ReportItem> getReportItems(@RequestParam(value = "reportItemName", required = false) String reportItemName,
                                           @RequestParam(value = "reportItemContent", required = false) String reportItemContent,
                                           @RequestParam(value = "reportItemType", required = false) Integer reportItemType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        ReportItem reportItem = new ReportItem();

        return reportItemService.findReportItems(reportItem, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param reportItem the add reportItem request
     * @return the integer
     */
    @RequestMapping(value = "/reportItems", method = RequestMethod.POST)
    public Integer addReportItem(@RequestBody ReportItem reportItem) {
        return reportItemService.insert(reportItem);
    }

    /**
     * 更新模板信息.
     *
     * @param reportItem the update reportItem request
     * @return the integer
     */
    @RequestMapping(value = "/reportItems", method = RequestMethod.PUT)
    public Integer updateReportItem(@RequestBody ReportItem reportItem) {
        return reportItemService.updateByReportItemId(reportItem);
    }

    /**
     * 根据指定的reportItemId删除模板信息
     *
     * @param reportItemId the reportItem id
     * @return the integer
     */
    @RequestMapping(value = "/reportItems/{reportItemId}", method = RequestMethod.DELETE)
    public Integer deleteReportItem(@PathVariable("reportItemId") Integer reportItemId) {
        return reportItemService.deleteByReportItemId(reportItemId);
    }

}
