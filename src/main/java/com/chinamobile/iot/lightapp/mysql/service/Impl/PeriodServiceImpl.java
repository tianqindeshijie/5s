package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.PeriodMapper;
import com.chinamobile.iot.lightapp.mysql.dao.PeriodMapperExt;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dto.PeriodDTO;
import com.chinamobile.iot.lightapp.mysql.model.Period;
import com.chinamobile.iot.lightapp.mysql.model.PeriodExample;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycleExample;
import com.chinamobile.iot.lightapp.mysql.service.PeriodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodMapper periodMapper;

    @Autowired
    private PeriodMapperExt periodMapperExt;

    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Override
    public PageInfo<PeriodDTO> findPeriods(Period period, Integer userId, Integer pageNum, Integer pageSize) {
        //查询用户所有的工作圈
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        List<Integer> workCycleList = new ArrayList<Integer>();
        if (list != null && list.size() > 0) {
            for (UserWorkcycle temp : list) {
                workCycleList.add(temp.getWorkCycleId());
            }
        }
        PeriodExample periodExample = new PeriodExample();
        PeriodExample.Criteria criteria1 = periodExample.createCriteria();
        String periodName = period.getPeriodName();
        if (periodName != null && periodName.trim().length() > 0) {
            criteria1.andPeriodNameLike(periodName);
        }
        Integer cycleId = period.getCycleId();
        if (cycleId != null) {
            criteria1.andCycleIdEqualTo(cycleId);
        }
        criteria1.andCycleIdIn(workCycleList);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<PeriodDTO> periodDTOList = periodMapperExt.selectByExample(periodExample);
        return new PageInfo<PeriodDTO>(periodDTOList);
    }

    @Override
    public Period findPeriodByPeriodId(Integer periodId) {
        return periodMapper.selectByPrimaryKey(periodId);
    }

    @Override
    public int deleteByPeriodId(Integer periodId) {
        return periodMapper.deleteByPrimaryKey(periodId);
    }

    @Override
    public int updateByPeriodId(Period period) {
        return periodMapper.updateByPrimaryKeySelective(period);
    }

    @Override
    public int insert(Period period) {
        return periodMapper.insertSelective(period);
    }

}
