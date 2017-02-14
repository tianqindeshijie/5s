package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycleExample;
import com.chinamobile.iot.lightapp.mysql.service.UserWorkcycleService;
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
public class UserWorkcycleServiceImpl implements UserWorkcycleService {

    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Override
    public PageInfo<UserWorkcycle> findUserWorkcycles(UserWorkcycle userWorkcycle, Integer pageNum, Integer pageSize) {
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<UserWorkcycle> list= userWorkcycleMapper.selectByExample(userWorkcycleExample);
        return new PageInfo<UserWorkcycle>(list);
    }

    @Override
    public UserWorkcycle findUserWorkcycleByUserWorkcycleId(Integer userWorkcycleId) {
        return userWorkcycleMapper.selectByPrimaryKey(userWorkcycleId);
    }

    @Override
    public int deleteByUserWorkcycleId(Integer userWorkcycleId) {
        return userWorkcycleMapper.deleteByPrimaryKey(userWorkcycleId);
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
