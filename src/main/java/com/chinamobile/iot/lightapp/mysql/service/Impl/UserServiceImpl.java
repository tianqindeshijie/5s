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

        String userName = user.getUserName();
        if (userName != null && userName.trim().length() > 0) {
            criteria.andUserNameEqualTo(userName);
        }

        String nickName = user.getNickName();
        if (nickName != null && nickName.length() > 0) {
            criteria.andNickNameEqualTo(nickName);
        }

        String phone = user.getPhone();
        if (phone != null && phone.length() > 0) {
            criteria.andPhoneEqualTo(phone);
        }

        String email = user.getEmail();
        if (email != null && email.length() > 0) {
            criteria.andEmailEqualTo(email);
        }
        String department = user.getDepartment();
        if (department != null && department.length() > 0) {
            criteria.andDepartmentLike(department);
        }
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<User> list = userMapper.selectByExample(userExample);
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

    @Override
    public boolean login(String userName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> list =  userMapper.selectByExample(userExample);
        if(list != null && list.size() > 0) {
            User user = list.get(0);
            if(password.trim().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean updatePassword(Integer userId,String oldPassword,String newPassword) {
        User user =  userMapper.selectByPrimaryKey(userId);
        if(user != null) {
            if(oldPassword.trim().equals(user.getPassword())) {
                user.setPassword(newPassword);
                userMapper.updateByPrimaryKeySelective(user);
                return true;
            }
        }
        return false;
    }
}
