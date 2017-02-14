package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.WorkCycleMapper;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycleExample;
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

    @Override
    public PageInfo<WorkCycle> findWorkCycles(WorkCycle workCycle, Integer pageNum, Integer pageSize) {
        WorkCycleExample workCycleExample = new WorkCycleExample();
        WorkCycleExample.Criteria criteria = workCycleExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<WorkCycle> list= workCycleMapper.selectByExample(workCycleExample);
        return new PageInfo<WorkCycle>(list);
    }

    @Override
    public WorkCycle findWorkCycleByWorkCycleId(Integer workCycleId) {
        return workCycleMapper.selectByPrimaryKey(workCycleId);
    }

    @Override
    public int deleteByWorkCycleId(Integer workCycleId) {
        return workCycleMapper.deleteByPrimaryKey(workCycleId);
    }

    @Override
    public int updateByWorkCycleId(WorkCycle workCycle) {
        return workCycleMapper.updateByPrimaryKeySelective(workCycle);
    }

    @Override
    public int insert(WorkCycle workCycle) {
        return workCycleMapper.insertSelective(workCycle);
    }

}
