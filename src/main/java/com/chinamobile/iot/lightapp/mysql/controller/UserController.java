package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.security.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.request.AddUserRequest;
import com.chinamobile.iot.lightapp.mysql.request.UpdatePasswordRequest;
import com.chinamobile.iot.lightapp.mysql.request.UpdateUserRequest;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController
@Api("用户管理")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据指定userId查询用户信息
     *
     */
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public BaseResponse getUserByUserId(@PathVariable("userId") Integer userId) {
       // Integer userId = SecurityUtils.getCurrentUserId();
        User user = userService.findUserByUserId(userId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功");
        response.setData(user);
        return response;
    }

    /**
     * 根据指定参数查询用户信息列表
     *
     * @param nickName   the nick name
     * @param phone      the phone
     * @param email      the email
     * @param department the department
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public BaseResponse getUsers(@RequestParam(value = "nickName", required = false) String nickName,
                                   @RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "department", required = false) String department,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        User user = new User();
        user.setNickName(nickName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setDepartment(department);
        PageInfo<User> pageInfo = userService.findUsers(user, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功");
        response.setData(pageInfo);
        return  response;
    }

    /**
     * POST  /register : 注册用户.
     *
     * @param addUserRequest the add user request
     * @return the base response
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse registerAccount(@Valid @RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        //拷贝属性
        BeanUtils.copyProperties(addUserRequest, user);
        userService.insert(user);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功");
        return  response;
    }

    /**
     * 更新用户信息.
     *
     * @param updateUserRequest the update user request
     * @return the integer
     */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public BaseResponse updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        User user = new User();
        //拷贝属性
        BeanUtils.copyProperties(updateUserRequest, user);
        userService.updateByUserId(user);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功");
        return  response;
    }

    /**
     * 根据指定的userId删除用户信息
     *
     * @param userId the user id
     * @return the integer
     */
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public BaseResponse deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteByUserId(userId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功");
        return  response;
    }

    /**
     * 登录
     *
     * @param userName the user name
     * @param password the password
     * @return the users
     */
    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public void login(@RequestParam(value = "userName", required = false) String userName,
                                   @RequestParam(value = "password", required = false) String password) {


    }

    /**
     * 更改密码
     *
     * @param updatePasswordRequest the update password request
     * @return the users
     */
    @RequestMapping(value = "/users/updatePassword", method = RequestMethod.GET)
    public BaseResponse updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        Integer userId = SecurityUtils.getCurrentUserId();
        String oldPassword = updatePasswordRequest.getOldPassword();
        String newPassword = updatePasswordRequest.getNewPassword();
        // TODO: 2017/2/15 从Session中取得
        userService.updatePassword(userId,oldPassword,newPassword);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功");
        return  response;
    }
}
