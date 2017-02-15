package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface UserService {


    /**
     * find users.
     *
     * @param user     the user
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the users
     */
    public PageInfo<User> findUsers(User user, Integer pageNum, Integer pageSize);

    /**
     * find user by user id.
     *
     * @param userId the user id
     * @return the user by user id
     */
    public User findUserByUserId(Integer userId);

    /**
     * Delete by user id int.
     *
     * @param userId the user id
     * @return the int
     */
    @Transactional
    public int deleteByUserId(Integer userId);

    /**
     * Update by user id int.
     *
     * @param user the user
     * @return the int
     */
    @Transactional
    public int updateByUserId(User user);

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    @Transactional
    public int insert(User user);

    public boolean login(String userName, String password);

    boolean updatePassword(Integer userId, String oldPassword, String newPassword);
}
