package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.UserMapper;
import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.model.UserExample;
import com.chinamobile.iot.lightapp.mysql.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findUsers(User user, Integer pageNum, Integer pageSize) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<User> list= userMapper.selectByExample(userExample);
        return new PageInfo<User>(list);
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int deleteByUserId(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateByUserId(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

}
