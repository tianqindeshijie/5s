package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.CheckItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.dao.ReportItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    @Autowired
    private ReportItemScoreMapper reportItemScoreMapper;

    @Override
    public PageInfo<CheckItemScore> findCheckItemScores(Integer reportItemId, Integer reportId, Integer pageNum, Integer pageSize) {
        ReportItemScoreExample reportItemScoreExample = new ReportItemScoreExample();
        ReportItemScoreExample.Criteria criteria = reportItemScoreExample.createCriteria();
        criteria.andReportIdEqualTo(reportId);
        criteria.andReportItemIdEqualTo(reportItemId);
        List<ReportItemScore> reportItemScoreList = reportItemScoreMapper.selectByExample(reportItemScoreExample);
        List<Integer> reportItemScoreIdList = new ArrayList<Integer>();
        if (CollectionUtils.isEmpty(reportItemScoreList)) {
            return null;
        } else {
            for (ReportItemScore temp : reportItemScoreList) {
                reportItemScoreIdList.add(temp.getReportItemScoreId());
            }
        }
        CheckItemScoreExample checkItemScoreExample = new CheckItemScoreExample();
        CheckItemScoreExample.Criteria criteria1 = checkItemScoreExample.createCriteria();
        criteria1.andReportItemScoreIdIn(reportItemScoreIdList);
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
    public int insert(List<CheckItemScore> checkItemScoreList) {
        if(!CollectionUtils.isEmpty(checkItemScoreList)) {
            for(CheckItemScore temp: checkItemScoreList) {
                checkItemScoreMapper.insertSelective(temp);
            }
        } else {
            throw new RuntimeException("no checkItemScore in the list!");
        }
        return 0;
    }

}
