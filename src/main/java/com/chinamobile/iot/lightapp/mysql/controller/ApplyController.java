package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.security.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.dto.ApplyResult;
import com.chinamobile.iot.lightapp.mysql.model.Apply;
import com.chinamobile.iot.lightapp.mysql.request.AddApplyRequest;
import com.chinamobile.iot.lightapp.mysql.request.UpdateApplyRequest;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.ApplyService;
import com.chinamobile.iot.lightapp.mysql.service.UserService;
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

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController
@RequestMapping("/mysql")
@Api("申请管理")
public class ApplyController {
    private static Logger logger = LoggerFactory.getLogger(ApplyController.class);
    @Autowired
    private ApplyService applyService;
    @Autowired
    private UserService userService;

    /**
     * 根据指定applyId查询申请信息
     *
     * @param applyId the apply id
     * @return the apply by apply id
     */
    @ApiOperation(value = "查询申请", notes = "查询申请")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "applyId", required = true, value = "申请ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/applys/{applyId}", method = RequestMethod.GET)
    public Apply getApplyByApplyId(@PathVariable("applyId") Integer applyId) {
        return applyService.findApplyByApplyId(applyId);
    }

    /**
     * 根据指定参数查询申请信息列表
     *
     * @param applyUser the apply user
     * @param inviter   the inviter
     * @param cycleId   the cycle id
     * @param pageNum   the page num
     * @param pageSize  the page size
     * @return the applys
     */
    @ApiOperation(value = "查询申请列表", notes = "查询申请列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "applyUser", value = "申请人ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "inviter", value = "邀请人ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "cycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/applys", method = RequestMethod.GET)
    public BaseResponse getApplys(@RequestParam(value = "applyUser", required = false) Integer applyUser,
                                     @RequestParam(value = "inviter", required = false) Integer inviter,
                                     @RequestParam(value = "cycleId", required = false) Integer cycleId,
                                     @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {

        Integer userId = SecurityUtils.getCurrentUserId();
        Apply apply = new Apply();
        apply.setApplyUser(applyUser);
        apply.setInviter(inviter);
        apply.setCycleId(cycleId);
        PageInfo<Apply> pageInfo = applyService.findApplys(apply,userId, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增申请信息.
     *
     * @param addApplyRequest the add apply request
     * @return the integer
     */
    @ApiOperation(value = "新增申请列表", notes = "新增申请列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/applys", method = RequestMethod.POST)
    public BaseResponse addApply(@RequestBody AddApplyRequest addApplyRequest) {
        BaseResponse response = new BaseResponse();
        //拷贝属性
        ApplyResult applyResult = applyService.insert(addApplyRequest.getApplyList());
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        response.setData(applyResult);
        return response;
    }

    /**
     * 处理申请信息.
     *
     * @param updateApplyRequest the update apply request
     * @return the integer
     */
    @ApiOperation(value = "处理申请", notes = "处理申请")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/applys", method = RequestMethod.PUT)
    public Integer updateApply(@RequestBody UpdateApplyRequest updateApplyRequest) {
        Apply apply = new Apply();
        //拷贝属性
        BeanUtils.copyProperties(updateApplyRequest, apply);
        return applyService.updateByApplyId(apply);
    }

}
