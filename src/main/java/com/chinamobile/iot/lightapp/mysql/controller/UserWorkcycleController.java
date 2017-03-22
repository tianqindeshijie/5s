package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.security.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.service.UserWorkcycleService;
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
@Api("用户工作圈关系管理")
public class UserWorkcycleController {
    private static Logger logger = LoggerFactory.getLogger(UserWorkcycleController.class);
    @Autowired
    private UserWorkcycleService userWorkcycleService;

    /**
     * 新增用户工作圈关系信息(添加成员).
     *
     * @param userWorkcycle the add userWorkcycle request
     * @return the integer
     */
    @ApiOperation(value = "新增用户工作圈关系", notes = "新增用户工作圈关系")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/userWorkcycles", method = RequestMethod.POST)
    public Integer addUserWorkcycle(@RequestBody UserWorkcycle userWorkcycle) {
        return userWorkcycleService.insert(userWorkcycle);
    }

    /**
     * 根据指定userWorkcycleId查询用户工作圈关系信息
     *
     * @param userWorkcycleId the userWorkcycle id
     * @return the userWorkcycle by userWorkcycle id
     */
    @ApiOperation(value = "查询用户工作圈关系", notes = "查询用户工作圈关系")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "userWorkcycleId", required = true, value = "用户工作圈关系ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/userWorkcycles/{userWorkcycleId}", method = RequestMethod.GET)
    public UserWorkcycle getUserWorkcycleByUserWorkcycleId(@PathVariable("userWorkcycleId") Integer userWorkcycleId) {
        return userWorkcycleService.findUserWorkcycleByUserWorkcycleId(userWorkcycleId);
    }

    /**
     * 根据指定参数查询用户工作圈关系信息列表
     *
     * @param workCycleId the work cycle id
     * @param pageNum     the page num
     * @param pageSize    the page size
     * @return the userWorkcycles
     */
    @ApiOperation(value = "查询用户工作圈关系列表", notes = "查询用户工作圈关系列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "workCycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/userWorkcycles", method = RequestMethod.GET)
    public PageInfo<User> getUserWorkcycles(@RequestParam(value = "workCycleId", required = true) Integer workCycleId,
                                            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        Integer userId = SecurityUtils.getCurrentUserId();
        return userWorkcycleService.findUserWorkcycles(userId, workCycleId, pageNum, pageSize);
    }


    /**
     * 更新用户工作圈关系信息.
     *
     * @param userWorkcycle the update userWorkcycle request
     * @return the integer
     */
    @ApiOperation(value = "更新用户工作圈关系", notes = "更新用户工作圈关系")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/userWorkcycles", method = RequestMethod.PUT)
    public Integer updateUserWorkcycle(@RequestBody UserWorkcycle userWorkcycle) {
        return userWorkcycleService.updateByUserWorkcycleId(userWorkcycle);
    }

    /**
     * 根据指定的userWorkcycleId删除用户工作圈关系信息
     *
     * @param workCycleId  the work cycle id
     * @param deleteUserId the delete user id
     * @return the integer
     */
    @ApiOperation(value = "删除用户工作圈关系", notes = "删除用户工作圈关系")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "workCycleId", value = "工作圈ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/userWorkcycles/removeMember", method = RequestMethod.DELETE)
    public Integer removeMember(@RequestParam(value = "workCycleId", required = true) Integer workCycleId,
                                @RequestParam(value = "userId", required = true) Integer deleteUserId) {
        Integer userId = SecurityUtils.getCurrentUserId();
        return userWorkcycleService.deleteByUserWorkcycleId(userId, deleteUserId, workCycleId);
    }

}
