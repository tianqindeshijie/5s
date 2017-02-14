package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.service.UserWorkcycleService;
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
public class UserWorkcycleController {
    private static Logger logger = LoggerFactory.getLogger(UserWorkcycleController.class);
    @Autowired
    private UserWorkcycleService userWorkcycleService;

    /**
     * 根据指定userWorkcycleId查询模板信息
     *
     * @param userWorkcycleId the userWorkcycle id
     * @return the userWorkcycle by userWorkcycle id
     */
    @RequestMapping(path = "/userWorkcycles/{userWorkcycleId}", method = RequestMethod.GET)
    public UserWorkcycle getUserWorkcycleByUserWorkcycleId(@PathVariable("userWorkcycleId") Integer userWorkcycleId) {
        return userWorkcycleService.findUserWorkcycleByUserWorkcycleId(userWorkcycleId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param userWorkcycleName    the userWorkcycle name
     * @param userWorkcycleContent the userWorkcycle content
     * @param userWorkcycleType    the userWorkcycle type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the userWorkcycles
     */

    @RequestMapping(value = "/userWorkcycles", method = RequestMethod.GET)
    public PageInfo<UserWorkcycle> getUserWorkcycles(@RequestParam(value = "userWorkcycleName", required = false) String userWorkcycleName,
                                           @RequestParam(value = "userWorkcycleContent", required = false) String userWorkcycleContent,
                                           @RequestParam(value = "userWorkcycleType", required = false) Integer userWorkcycleType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        UserWorkcycle userWorkcycle = new UserWorkcycle();

        return userWorkcycleService.findUserWorkcycles(userWorkcycle, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param userWorkcycle the add userWorkcycle request
     * @return the integer
     */
    @RequestMapping(value = "/userWorkcycles", method = RequestMethod.POST)
    public Integer addUserWorkcycle(@RequestBody UserWorkcycle userWorkcycle) {
        return userWorkcycleService.insert(userWorkcycle);
    }

    /**
     * 更新模板信息.
     *
     * @param userWorkcycle the update userWorkcycle request
     * @return the integer
     */
    @RequestMapping(value = "/userWorkcycles", method = RequestMethod.PUT)
    public Integer updateUserWorkcycle(@RequestBody UserWorkcycle userWorkcycle) {
        return userWorkcycleService.updateByUserWorkcycleId(userWorkcycle);
    }

    /**
     * 根据指定的userWorkcycleId删除模板信息
     *
     * @param userWorkcycleId the userWorkcycle id
     * @return the integer
     */
    @RequestMapping(value = "/userWorkcycles/{userWorkcycleId}", method = RequestMethod.DELETE)
    public Integer deleteUserWorkcycle(@PathVariable("userWorkcycleId") Integer userWorkcycleId) {
        return userWorkcycleService.deleteByUserWorkcycleId(userWorkcycleId);
    }

}
