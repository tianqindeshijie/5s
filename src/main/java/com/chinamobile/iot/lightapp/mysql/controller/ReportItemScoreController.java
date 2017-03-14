package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.ReportItemScore;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemScoreService;
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
public class ReportItemScoreController {
    private static Logger logger = LoggerFactory.getLogger(ReportItemScoreController.class);
    @Autowired
    private ReportItemScoreService reportItemScoreService;

    /**
     * 根据指定reportItemScoreId查询检查大项信息
     *
     * @param reportItemScoreId the reportItemScore id
     * @return the reportItemScore by reportItemScore id
     */
    @RequestMapping(path = "/reportItemScores/{reportItemScoreId}", method = RequestMethod.GET)
    public ReportItemScore getReportItemScoreByReportItemScoreId(@PathVariable("reportItemScoreId") Integer reportItemScoreId) {
        return reportItemScoreService.findReportItemScoreByReportItemScoreId(reportItemScoreId);
    }

    /**
     * 根据指定参数查询检查大项信息列表
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the reportItemScores
     */

    @RequestMapping(value = "/reportItemScores", method = RequestMethod.GET)
    public BaseResponse getReportItemScores(@RequestParam(value = "reportId", required = true) Integer reportId,
                                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        ReportItemScore reportItemScore = new ReportItemScore();
        reportItemScore.setReportId(reportId);
        PageInfo<ReportItemScore> pageInfo = reportItemScoreService.findReportItemScores(reportItemScore, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增检查大项信息.
     *
     * @param reportItemScore the add reportItemScore request
     * @return the integer
     */
    @RequestMapping(value = "/reportItemScores", method = RequestMethod.POST)
    public BaseResponse addReportItemScore(@RequestBody ReportItemScore reportItemScore) {
        reportItemScoreService.insert(reportItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新检查大项信息.
     *
     * @param reportItemScore the update reportItemScore request
     * @return the integer
     */
    @RequestMapping(value = "/reportItemScores", method = RequestMethod.PUT)
    public BaseResponse updateReportItemScore(@RequestBody ReportItemScore reportItemScore) {
        reportItemScoreService.updateByReportItemScoreId(reportItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的reportItemScoreId删除检查大项信息
     *
     * @param reportItemScoreId the reportItemScore id
     * @return the integer
     */
    @RequestMapping(value = "/reportItemScores/{reportItemScoreId}", method = RequestMethod.DELETE)
    public BaseResponse deleteReportItemScore(@PathVariable("reportItemScoreId") Integer reportItemScoreId) {
        reportItemScoreService.deleteByReportItemScoreId(reportItemScoreId);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

}
