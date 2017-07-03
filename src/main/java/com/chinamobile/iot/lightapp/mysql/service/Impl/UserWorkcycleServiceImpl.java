package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.UserMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserMapperExt;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dao.WorkCycleMapper;
import com.chinamobile.iot.lightapp.mysql.dto.WorkCycleUserDTO;
import com.chinamobile.iot.lightapp.mysql.exception.AccessDeniedException;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycleExample;
import com.chinamobile.iot.lightapp.mysql.service.UserWorkcycleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class UserWorkcycleServiceImpl implements UserWorkcycleService {

    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperExt userMapperExt;
    @Autowired
    private WorkCycleMapper workCycleMapper;

    @Override
    public PageInfo<WorkCycleUserDTO> findUserWorkcycles(Integer userId, Integer workCycleId, Integer pageNum, Integer pageSize) {
        //判断用户是否为该workcycle用户
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycleId).andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        List<WorkCycleUserDTO> userList = userMapperExt.selectByWorkcycleId(workCycleId);
        return new PageInfo<WorkCycleUserDTO>(userList);
    }

    @Override
    public UserWorkcycle findUserWorkcycleByUserWorkcycleId(Integer userWorkcycleId) {
        return userWorkcycleMapper.selectByPrimaryKey(userWorkcycleId);
    }

    @Override
    public int deleteByUserWorkcycleId(Integer userId, Integer deleteUserId, Integer workCycleId) {
        //判断用户是否为该workcycle管理员
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycleId).andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (!CollectionUtils.isEmpty(list)) {
            UserWorkcycle userWorkcycle = list.get(0);
            if (userWorkcycle.getIsManager() == Constant.CYCLE_MEMBER) {
                throw new AccessDeniedException("You have no right to operate this work cycle!");
            }
        } else {
            throw new AccessDeniedException("You have no right to operate this work cycle!");
        }
        UserWorkcycle userWorkcycle = list.get(0);
        //删除用户和工作圈的关系
        userWorkcycleExample.clear();
        criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycleId).andUserIdEqualTo(deleteUserId);
        return userWorkcycleMapper.deleteByExample(userWorkcycleExample);
    }

    @Override
    public int updateByUserWorkcycleId(UserWorkcycle userWorkcycle) {
        return userWorkcycleMapper.updateByPrimaryKeySelective(userWorkcycle);
    }

    @Override
    public int insert(UserWorkcycle userWorkcycle) {
        return userWorkcycleMapper.insertSelective(userWorkcycle);
    }

}
