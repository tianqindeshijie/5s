package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.*;
import com.chinamobile.iot.lightapp.mysql.dto.*;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.service.WorkCycleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
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
    private WorkCycleMapperExt workCycleMapperExt;
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Autowired
    private UserWorkcycleMapperExt userWorkcycleMapperExt;

    @Autowired
    private ReportItemMapper reportItemMapper;

    @Autowired
    private CheckItemMapper checkItemMapper;
    @Override
    public PageInfo<WorkCycle> findWorkCycles(WorkCycle workCycle, Integer pageNum, Integer pageSize) {
        WorkCycleExample workCycleExample = new WorkCycleExample();
        WorkCycleExample.Criteria criteria = workCycleExample.createCriteria();
        criteria.andWorkCycleNameLike(workCycle.getWorkCycleName() + "%");
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<WorkCycle> list = workCycleMapper.selectByExample(workCycleExample);
        return new PageInfo<WorkCycle>(list);
    }

    @Override
    public WorkCycleAndRegion findWorkCycleByWorkCycleId(Integer workCycleId) {
        WorkCycle workCycle = workCycleMapper.selectByPrimaryKey(workCycleId);
        WorkCycleAndRegion workCycleAndRegion = new WorkCycleAndRegion();
        BeanUtils.copyProperties(workCycle, workCycleAndRegion);
        //查询Region信息
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria criteria = regionExample.createCriteria();
        criteria.andCycleIdEqualTo(workCycleId);
        List<Region> regionList = regionMapper.selectByExample(regionExample);
        workCycleAndRegion.setRegionList(regionList);
        return workCycleAndRegion;
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
            throw new RuntimeException("no rights to operate the work cycle!");
        }
        workCycleMapper.deleteByPrimaryKey(workCycleId);
        //删除用户和工作圈的关系
        userWorkcycleExample.clear();
        criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycleId);
        userWorkcycleMapper.deleteByExample(userWorkcycleExample);
        //// TODO: 2017/6/30删除工作圈对于的区域

        // TODO: 2017/6/30 删除工作圈对于的检查大项和小项

        return SUCCESS;
    }

    @Override
    public int updateByWorkCycleId(Integer userId, UpdateWorkCycleAndRegion updateWorkCycleAndRegion) {
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(updateWorkCycleAndRegion.getWorkCycleId());
        criteria.andUserIdEqualTo(userId);
        criteria.andIsManagerNotEqualTo(Constant.CYCLE_MEMBER);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (list == null && list.size() == 0) {
            return NO_PERMISSION;
        }
        workCycleMapper.updateByPrimaryKeySelective(updateWorkCycleAndRegion);
        List<UpdateRegionDTO> regionList = updateWorkCycleAndRegion.getRegionList();
        for (UpdateRegionDTO temp : regionList) {
            int operateType = temp.getOperateType();
            if(operateType == Constant.OPERATE_TYPE_ADD) {
                regionMapper.insert(temp);
            } else if(operateType == Constant.OPERATE_TYPE_UPDATE) {
                regionMapper.updateByPrimaryKeySelective(temp);
            }else if(operateType == Constant.OPERATE_TYPE_DELETE) {
                regionMapper.deleteByPrimaryKey(temp.getRegionId());
            }
        }
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

    /**
     * Find work cycle by user id work cycle.
     *
     * @param userId the user id
     * @return the work cycle
     */
    @Override
    public PageInfo<UserWorkcycleDTO> findWorkCycleByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<UserWorkcycleDTO> list = userWorkcycleMapperExt.selectByExample(userWorkcycleExample);
        return new PageInfo<UserWorkcycleDTO>(list);
    }

}
