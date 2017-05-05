package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.ReportItemScoreVO;
import com.chinamobile.iot.lightapp.mysql.model.ReportItemScore;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemScoreService;
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

@Api("检查大项评分管理")
public class ReportItemScoreController {
    private static Logger logger = LoggerFactory.getLogger(ReportItemScoreController.class);
    @Autowired
    private ReportItemScoreService reportItemScoreService;

    /**
     * 根据指定reportItemScoreId查询检查大项评分信息
     *
     * @param reportItemScoreId the reportItemScore id
     * @return the reportItemScore by reportItemScore id
     */
    @ApiOperation(value = "查询检查大项评分", notes = "查询检查大项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "reportItemScoreId", required = true, value = "检查大项评分ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/reportItemScores/{reportItemScoreId}", method = RequestMethod.GET)
    public BaseResponse getReportItemScoreByReportItemScoreId(@PathVariable("reportItemScoreId") Integer reportItemScoreId) {
        ReportItemScore reportItemScore = reportItemScoreService.findReportItemScoreByReportItemScoreId(reportItemScoreId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(reportItemScore);
        return response;
    }

    /**
     * 根据指定参数查询检查大项评分信息列表
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the reportItemScores
     */
    @ApiOperation(value = "查询检查大项评分列表", notes = "查询检查大项评分列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "reportId", required = true, value = "报告ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItemScores", method = RequestMethod.GET)
    public BaseResponse getReportItemScores(@RequestParam(value = "reportId", required = true) Integer reportId,
                                            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        ReportItemScore reportItemScore = new ReportItemScore();
        reportItemScore.setReportId(reportId);
        PageInfo<ReportItemScoreVO> pageInfo = reportItemScoreService.findReportItemScores(reportItemScore, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增检查大项评分信息.
     *
     * @param reportItemScore the add reportItemScore request
     * @return the integer
     */
    @ApiOperation(value = "新增检查大项评分", notes = "新增检查大项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItemScores", method = RequestMethod.POST)
    public BaseResponse addReportItemScore(@RequestBody ReportItemScore reportItemScore) {
        reportItemScoreService.insert(reportItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 更新检查大项评分信息.
     *
     * @param reportItemScore the update reportItemScore request
     * @return the integer
     */
    @ApiOperation(value = "更新检查大项评分", notes = "更新检查大项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItemScores", method = RequestMethod.PUT)
    public BaseResponse updateReportItemScore(@RequestBody ReportItemScore reportItemScore) {
        reportItemScoreService.updateByReportItemScoreId(reportItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 根据指定的reportItemScoreId删除检查大项评分信息
     *
     * @param reportItemScoreId the reportItemScore id
     * @return the integer
     */
    @ApiOperation(value = "删除检查大项评分", notes = "删除检查大项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "reportItemScoreId", required = true, value = "检查大项评分ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportItemScores/{reportItemScoreId}", method = RequestMethod.DELETE)
    public BaseResponse deleteReportItemScore(@PathVariable("reportItemScoreId") Integer reportItemScoreId) {
        reportItemScoreService.deleteByReportItemScoreId(reportItemScoreId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

}
