package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.request.UpdatePasswordRequest;
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
@Api("用户管理")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据指定userId查询用户信息
     *
     * @param userId the user id
     * @return the user by user id
     */
    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable("userId") Integer userId) {
        return userService.findUserByUserId(userId);
    }

    /**
     * 根据指定参数查询用户信息列表
     *
     * @param userName the user name
     * @param nickName the nick name
     * @param phone    the phone
     * @param email    the email
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public PageInfo<User> getUsers(@RequestParam(value = "userName", required = false) String userName,
                                   @RequestParam(value = "nickName", required = false) String nickName,
                                   @RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "department", required = false) String department,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        User user = new User();
        user.setUserName(userName);
        user.setNickName(nickName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setDepartment(department);
        return userService.findUsers(user, pageNum, pageSize);
    }

    /**
     * 新增用户信息.
     *
     * @param user the add user request
     * @return the integer
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user) {
        return userService.insert(user);
    }

    /**
     * 更新用户信息.
     *
     * @param user the update user request
     * @return the integer
     */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public Integer updateUser(@RequestBody User user) {
        return userService.updateByUserId(user);
    }

    /**
     * 根据指定的userId删除用户信息
     *
     * @param userId the user id
     * @return the integer
     */
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public Integer deleteUser(@PathVariable("userId") Integer userId) {
        return userService.deleteByUserId(userId);
    }

    /**
     * 登录
     *
     * @return the users
     */
    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public int login(@RequestParam(value = "userName", required = false) String userName,
                                   @RequestParam(value = "password", required = false) String password) {
        userService.login(userName,password);
        return 0;
    }

    /**
     * 更改密码
     *
     * @return the users
     */
    @RequestMapping(value = "/users/{userId}/updatePassword", method = RequestMethod.GET)
    public int updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {

        String oldPassword = updatePasswordRequest.getOldPassword();
        String newPassword = updatePasswordRequest.getNewPassword();
        // TODO: 2017/2/15 从Session中取得
        Integer userId = 0;
        userService.updatePassword(userId,oldPassword,newPassword);
        return 0;
    }
}
