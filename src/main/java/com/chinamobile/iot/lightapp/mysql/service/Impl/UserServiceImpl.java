package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.UserMapper;
import com.chinamobile.iot.lightapp.mysql.exception.EmailExistsException;
import com.chinamobile.iot.lightapp.mysql.exception.NickNameExistsException;
import com.chinamobile.iot.lightapp.mysql.exception.PhoneExistsException;
import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.model.UserExample;
import com.chinamobile.iot.lightapp.mysql.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User findUserByNickName(String nickName) {
        if (nickName == null || nickName.trim().length() == 0) {
            return null;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        List<User> list = userMapper.selectByExample(userExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public User findUserByPhone(String phone) {
        if (phone == null || phone.trim().length() == 0) {
            return null;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<User> list = userMapper.selectByExample(userExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
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
        //判断昵称是否重复
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        String nickName = user.getNickName();
        criteria.andNickNameEqualTo(nickName);
        List<User> list1 = userMapper.selectByExample(userExample);
        if(list1 != null && list1.size() != 0) {
            throw new NickNameExistsException("昵称已经存！");
        }
        userExample.clear();
        String phone = user.getPhone();
        UserExample.Criteria criteria2 = userExample.createCriteria();
        criteria2.andPhoneEqualTo(phone);
        List<User> list2 = userMapper.selectByExample(userExample);
        if(list2 != null && list2.size() != 0) {
            throw new PhoneExistsException("手机号码已经存！");
        }
        userExample.clear();
        String email = user.getEmail();
        UserExample.Criteria criteria3 = userExample.createCriteria();
        criteria3.andEmailEqualTo(email);
        List<User> list3 = userMapper.selectByExample(userExample);
        if(list3 != null && list3.size() != 0) {
            throw new EmailExistsException("邮箱已经存！");
        }
        return userMapper.insertSelective(user);
    }


    @Override
    public boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            if (oldPassword.trim().equals(user.getPassword())) {
                user.setPassword(newPassword);
                userMapper.updateByPrimaryKeySelective(user);
                return true;
            }
        }
        return false;
    }
}
