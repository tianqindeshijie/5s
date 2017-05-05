package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.AddCheckItemScoreRequest;
import com.chinamobile.iot.lightapp.mysql.dto.CheckItemScoreDTO;
import com.chinamobile.iot.lightapp.mysql.dto.CheckItemScoreVO;
import com.chinamobile.iot.lightapp.mysql.model.CheckItemScore;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemScoreService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController

@Api("检查小项评分管理")
public class CheckItemScoreController {
    private static Logger logger = LoggerFactory.getLogger(CheckItemScoreController.class);
    @Autowired
    private CheckItemScoreService checkItemScoreService;

    /**
     * 根据指定checkItemScoreId查询检查小项评分信息
     *
     * @param checkItemScoreId the checkItemScore id
     * @return the checkItemScore by checkItemScore id
     */
    @ApiOperation(value = "查询检查小项评分", notes = "查询检查小项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "checkItemScoreId", required = true, value = "检查小项评分ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/checkItemScores/{checkItemScoreId}", method = RequestMethod.GET)
    public BaseResponse getCheckItemScoreByCheckItemScoreId(@PathVariable("checkItemScoreId") Integer checkItemScoreId) {
        CheckItemScore checkItemScore = checkItemScoreService.findCheckItemScoreByCheckItemScoreId(checkItemScoreId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(checkItemScore);
        return response;
    }

    /**
     * 根据指定参数查询检查小项评分信息列表
     *
     * @param reportItemId the report item id
     * @param reportId     the report id
     * @param pageNum      the page num
     * @param pageSize     the page size
     * @return the checkItemScores
     */
    @ApiOperation(value = "查询检查小项评分列表", notes = "查询检查小项评分列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "reportItemId", required = true, value = "检查大项ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "reportId", required = true, value = "报告ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItemScores", method = RequestMethod.GET)
    public BaseResponse getCheckItemScores(@RequestParam(value = "reportItemId", required = true) Integer reportItemId,
                                           @RequestParam(value = "reportId", required = true) Integer reportId,
                                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {

        PageInfo<CheckItemScoreDTO> pageInfo = checkItemScoreService.findCheckItemScores(reportItemId, reportId, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增检查小项评分信息.
     *
     * @param addCheckItemScoreRequest the add check item score request
     * @return the integer
     */
    @ApiOperation(value = "新增检查小项评分", notes = "新增检查小项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItemScores", method = RequestMethod.POST)
    public BaseResponse addCheckItemScore(@RequestBody AddCheckItemScoreRequest addCheckItemScoreRequest) {
        Integer reportItemId = addCheckItemScoreRequest.getReportItemId();
        Integer reportId = addCheckItemScoreRequest.getReportId();
        List<CheckItemScore> list = new ArrayList<CheckItemScore>();
        if (!CollectionUtils.isEmpty(addCheckItemScoreRequest.getCheckItemScoreList())) {
            for (CheckItemScoreVO temp : addCheckItemScoreRequest.getCheckItemScoreList()) {
                CheckItemScore checkItemScore = new CheckItemScore();
                checkItemScore.setRemarkContent(temp.getRemarkContent());
                checkItemScore.setScore(temp.getScore());
                checkItemScore.setCheckItemId(temp.getCheckItemId());
                list.add(checkItemScore);
            }
        } else {
            throw new RuntimeException("no checkItemScore in the list!");
        }
        checkItemScoreService.insert(reportId, reportItemId, list);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 更新检查小项评分信息.
     *
     * @param checkItemScore the update checkItemScore request
     * @return the integer
     */
    @ApiOperation(value = "更新检查小项评分", notes = "更新检查小项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItemScores", method = RequestMethod.PUT)
    public BaseResponse updateCheckItemScore(@RequestBody CheckItemScore checkItemScore) {
        checkItemScoreService.updateByCheckItemScoreId(checkItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 根据指定的checkItemScoreId删除检查小项评分信息
     *
     * @param checkItemScoreId the checkItemScore id
     * @return the integer
     */
    @ApiOperation(value = "删除检查小项评分", notes = "删除检查小项评分")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "checkItemScoreId", required = true, value = "检查小项评分ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItemScores/{checkItemScoreId}", method = RequestMethod.DELETE)
    public BaseResponse deleteCheckItemScore(@PathVariable("checkItemScoreId") Integer checkItemScoreId) {
        checkItemScoreService.deleteByCheckItemScoreId(checkItemScoreId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

}
