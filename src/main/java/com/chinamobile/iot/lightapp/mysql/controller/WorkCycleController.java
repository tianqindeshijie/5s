package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.AddWorkCycleRequest;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.WorkCycleService;
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

import java.util.HashMap;
import java.util.Map;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController

@Api("工作圈管理")
public class WorkCycleController {
    private static Logger logger = LoggerFactory.getLogger(WorkCycleController.class);
    @Autowired
    private WorkCycleService workCycleService;

    /**
     * 根据指定workCycleId查询工作圈信息
     *
     * @param workCycleId the workCycle id
     * @return the workCycle by workCycle id
     */
    @ApiOperation(value = "查询工作圈", notes = "查询工作圈")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "workCycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/workCycles/{workCycleId}", method = RequestMethod.GET)
    public BaseResponse getWorkCycleByWorkCycleId(@PathVariable("workCycleId") Integer workCycleId) {
        WorkCycle workCycle = workCycleService.findWorkCycleByWorkCycleId(workCycleId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(workCycle);
        return response;
    }

    /**
     * 根据指定参数查询工作圈信息列表
     *
     * @param workCycleName the workCycle name
     * @param pageNum       the page num
     * @param pageSize      the page size
     * @return the workCycles
     */
    @ApiOperation(value = "查询工作圈列表", notes = "查询工作圈列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "workCycleName", value = "工作圈名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/workCycles", method = RequestMethod.GET)
    public BaseResponse getWorkCycles(@RequestParam(value = "workCycleName", required = true) String workCycleName,
                                      @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        WorkCycle workCycle = new WorkCycle();
        workCycle.setWorkCycleName(workCycleName);
        PageInfo<WorkCycle> pageInfo = workCycleService.findWorkCycles(workCycle, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 根据指定userId查询工作圈信息
     *
     * @param userId the user id
     * @return the work cycle by user id
     */
    @ApiOperation(value = "根据用户ID查询工作圈", notes = "根据用户ID查询工作圈")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "userId", value = "用户ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/users/workCycles", method = RequestMethod.GET)
    public BaseResponse getWorkCycleByUserId(@RequestParam(value = "userId", required = true) Integer userId,
                                             @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        PageInfo<WorkCycle> pageInfo = workCycleService.findWorkCycleByUserId(userId, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增工作圈信息.
     *
     * @param addWorkCycleRequest the add work cycle request
     * @return the integer
     */
    @ApiOperation(value = "新增工作圈", notes = "新增工作圈")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/workCycles", method = RequestMethod.POST)
    public BaseResponse addWorkCycle(@RequestBody AddWorkCycleRequest addWorkCycleRequest) {
        WorkCycle workCycle = new WorkCycle();
        workCycle.setWorkCycleName(addWorkCycleRequest.getWorkCycleName());
        Integer userId = SecurityUtils.getCurrentUserId();
        Integer workCycleId = workCycleService.insert(userId, workCycle, addWorkCycleRequest.getRegionList());
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        Map map = new HashMap<String, Integer>();
        map.put("workCycleId", workCycleId);
        response.setData(map);
        return response;
    }

    /**
     * 更新工作圈信息.
     *
     * @param workCycle the update workCycle request
     * @return the integer
     */
    @ApiOperation(value = "更新工作圈", notes = "更新工作圈")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/workCycles", method = RequestMethod.PUT)
    public BaseResponse updateWorkCycle(@RequestBody WorkCycle workCycle) {
        Integer userId = SecurityUtils.getCurrentUserId();
        workCycleService.updateByWorkCycleId(userId, workCycle);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 根据指定的workCycleId删除工作圈信息
     *
     * @param workCycleId the workCycle id
     * @return the integer
     */
    @ApiOperation(value = "删除工作圈", notes = "删除工作圈")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "workCycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/workCycles/{workCycleId}", method = RequestMethod.DELETE)
    public BaseResponse deleteWorkCycle(@PathVariable("workCycleId") Integer workCycleId) {
        // TODO: 2017/2/16 判断操作人是否有权限删除
        Integer userId = SecurityUtils.getCurrentUserId();
        workCycleService.deleteByWorkCycleId(userId, workCycleId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

}
