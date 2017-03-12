package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.dto.ApplyResult;
import com.chinamobile.iot.lightapp.mysql.model.Apply;
import com.chinamobile.iot.lightapp.mysql.model.User;
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
     * 更新申请信息.
     *
     * @param updateApplyRequest the update apply request
     * @return the integer
     */
    @RequestMapping(value = "/applys", method = RequestMethod.PUT)
    public Integer updateApply(@RequestBody UpdateApplyRequest updateApplyRequest) {
        Apply apply = new Apply();
        //拷贝属性
        BeanUtils.copyProperties(updateApplyRequest, apply);
        return applyService.updateByApplyId(apply);
    }

}
