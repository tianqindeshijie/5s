package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.CheckItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.model.CheckItemScore;
import com.chinamobile.iot.lightapp.mysql.model.CheckItemScoreExample;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemScoreService;
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
public class CheckItemScoreServiceImpl implements CheckItemScoreService {

    @Autowired
    private CheckItemScoreMapper checkItemScoreMapper;

    @Override
    public PageInfo<CheckItemScore> findCheckItemScores(CheckItemScore checkItemScore, Integer pageNum, Integer pageSize) {
        CheckItemScoreExample checkItemScoreExample = new CheckItemScoreExample();
        CheckItemScoreExample.Criteria criteria = checkItemScoreExample.createCriteria();
        criteria.andReportItemScoreIdEqualTo(checkItemScore.getReportItemScoreId());

        PageHelper.startPage(pageNum, pageSize, true, false);
        List<CheckItemScore> list = checkItemScoreMapper.selectByExample(checkItemScoreExample);
        return new PageInfo<CheckItemScore>(list);
    }

    @Override
    public CheckItemScore findCheckItemScoreByCheckItemScoreId(Integer checkItemScoreId) {
        return checkItemScoreMapper.selectByPrimaryKey(checkItemScoreId);
    }

    @Override
    public int deleteByCheckItemScoreId(Integer checkItemScoreId) {
        return checkItemScoreMapper.deleteByPrimaryKey(checkItemScoreId);
    }

    @Override
    public int updateByCheckItemScoreId(CheckItemScore checkItemScore) {
        return checkItemScoreMapper.updateByPrimaryKeySelective(checkItemScore);
    }

    @Override
    public int insert(CheckItemScore checkItemScore) {
        return checkItemScoreMapper.insertSelective(checkItemScore);
    }

}
