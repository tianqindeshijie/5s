package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.ReportItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.dao.ReportItemScoreMapperExt;
import com.chinamobile.iot.lightapp.mysql.dto.ReportItemScoreVO;
import com.chinamobile.iot.lightapp.mysql.model.ReportItemScore;
import com.chinamobile.iot.lightapp.mysql.model.ReportItemScoreExample;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemScoreService;
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
public class ReportItemScoreServiceImpl implements ReportItemScoreService {

    @Autowired
    private ReportItemScoreMapper reportItemScoreMapper;
    @Autowired
    private ReportItemScoreMapperExt reportItemScoreMapperExt;
    @Override
    public PageInfo<ReportItemScoreVO> findReportItemScores(ReportItemScore reportItemScore, Integer pageNum, Integer pageSize) {
        ReportItemScoreExample reportItemScoreExample = new ReportItemScoreExample();
        ReportItemScoreExample.Criteria criteria = reportItemScoreExample.createCriteria();
        Integer reportId = reportItemScore.getReportId();
        criteria.andReportIdEqualTo(reportId);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<ReportItemScoreVO> list = reportItemScoreMapperExt.selectByExample(reportItemScoreExample);
        return new PageInfo<ReportItemScoreVO>(list);
    }

    @Override
    public ReportItemScore findReportItemScoreByReportItemScoreId(Integer reportItemScoreId) {
        return reportItemScoreMapper.selectByPrimaryKey(reportItemScoreId);
    }

    @Override
    public int deleteByReportItemScoreId(Integer reportItemScoreId) {
        return reportItemScoreMapper.deleteByPrimaryKey(reportItemScoreId);
    }

    @Override
    public int updateByReportItemScoreId(ReportItemScore reportItemScore) {
        return reportItemScoreMapper.updateByPrimaryKeySelective(reportItemScore);
    }

    @Override
    public int insert(ReportItemScore reportItemScore) {
        return reportItemScoreMapper.insertSelective(reportItemScore);
    }

}
