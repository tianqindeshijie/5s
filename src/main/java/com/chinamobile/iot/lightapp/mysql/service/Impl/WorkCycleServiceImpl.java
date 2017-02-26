package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.RegionMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dao.WorkCycleMapper;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.service.UserWorkcycleService;
import com.chinamobile.iot.lightapp.mysql.service.WorkCycleService;
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
public class WorkCycleServiceImpl implements WorkCycleService {

    @Autowired
    private WorkCycleMapper workCycleMapper;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Override
    public PageInfo<WorkCycle> findWorkCycles(WorkCycle workCycle, Integer pageNum, Integer pageSize) {
        WorkCycleExample workCycleExample = new WorkCycleExample();
        WorkCycleExample.Criteria criteria = workCycleExample.createCriteria();
        criteria.andWorkCycleNameEqualTo(workCycle.getWorkCycleName());
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<WorkCycle> list = workCycleMapper.selectByExample(workCycleExample);
        return new PageInfo<WorkCycle>(list);
    }

    @Override
    public WorkCycle findWorkCycleByWorkCycleId(Integer workCycleId) {
        return workCycleMapper.selectByPrimaryKey(workCycleId);
    }

    @Override
    public int deleteByWorkCycleId(Integer userId, Integer workCycleId) {
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycleId);
        criteria.andUserIdEqualTo(userId);
        criteria.andIsManagerEqualTo(Constant.CYCLE_CREATER);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (list == null && list.size() == 0) {
            return NO_PERMISSION;
        }
        workCycleMapper.deleteByPrimaryKey(workCycleId);
        return SUCCESS;
    }

    @Override
    public int updateByWorkCycleId(Integer userId, WorkCycle workCycle) {
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycle.getWorkCycleId());
        criteria.andUserIdEqualTo(userId);
        criteria.andIsManagerEqualTo(Constant.CYCLE_CREATER);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (list == null && list.size() == 0) {
            return NO_PERMISSION;
        }
        workCycleMapper.updateByPrimaryKeySelective(workCycle);
        return SUCCESS;
    }

    @Override
    public int insert(Integer userId, WorkCycle workCycle, List<Region> regionList) {
        //新增工作圈信息
        workCycleMapper.insertSelective(workCycle);
        //新增区域信息
        Integer workCycleId = workCycle.getWorkCycleId();
        if (regionList != null) {
            for (Region temp : regionList) {
                temp.setCycleId(workCycleId);
                regionMapper.insert(temp);
            }
        }
        //新增用户工作圈权限
        UserWorkcycle userWorkcycle = new UserWorkcycle();
        userWorkcycle.setUserId(userId);
        userWorkcycle.setWorkCycleId(workCycleId);
        userWorkcycle.setIsManager(Constant.CYCLE_CREATER);
        userWorkcycleMapper.insert(userWorkcycle);
        return workCycleId;
    }

}
