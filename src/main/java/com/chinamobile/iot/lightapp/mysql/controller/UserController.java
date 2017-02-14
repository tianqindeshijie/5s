package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.service.UserService;
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
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据指定userId查询模板信息
     *
     * @param userId the user id
     * @return the user by user id
     */
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable("userId") Integer userId) {
        return userService.findUserByUserId(userId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param userName    the user name
     * @param userContent the user content
     * @param userType    the user type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the users
     */

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public PageInfo<User> getUsers(@RequestParam(value = "userName", required = false) String userName,
                                           @RequestParam(value = "userContent", required = false) String userContent,
                                           @RequestParam(value = "userType", required = false) Integer userType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        User user = new User();

        return userService.findUsers(user, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param user the add user request
     * @return the integer
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user) {
        return userService.insert(user);
    }

    /**
     * 更新模板信息.
     *
     * @param user the update user request
     * @return the integer
     */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public Integer updateUser(@RequestBody User user) {
        return userService.updateByUserId(user);
    }

    /**
     * 根据指定的userId删除模板信息
     *
     * @param userId the user id
     * @return the integer
     */
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public Integer deleteUser(@PathVariable("userId") Integer userId) {
        return userService.deleteByUserId(userId);
    }

}
