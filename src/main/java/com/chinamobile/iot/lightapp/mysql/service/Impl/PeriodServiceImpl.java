package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.PeriodMapper;
import com.chinamobile.iot.lightapp.mysql.model.Period;
import com.chinamobile.iot.lightapp.mysql.model.PeriodExample;
import com.chinamobile.iot.lightapp.mysql.service.PeriodService;
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
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodMapper periodMapper;

    @Override
    public PageInfo<Period> findPeriods(Period period, Integer pageNum, Integer pageSize) {
        PeriodExample periodExample = new PeriodExample();
        PeriodExample.Criteria criteria = periodExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<Period> list= periodMapper.selectByExample(periodExample);
        return new PageInfo<Period>(list);
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
