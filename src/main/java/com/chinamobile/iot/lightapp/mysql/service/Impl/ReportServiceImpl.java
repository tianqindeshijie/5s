package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.ReportMapper;
import com.chinamobile.iot.lightapp.mysql.model.Report;
import com.chinamobile.iot.lightapp.mysql.model.ReportExample;
import com.chinamobile.iot.lightapp.mysql.service.ReportService;
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
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public PageInfo<Report> findReports(Report report, Integer pageNum, Integer pageSize) {
        ReportExample reportExample = new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        String reportName = report.getReportName();
        if (reportName != null && reportName.trim().length() > 0) {
            criteria.andReportNameLike(reportName);
        }
        Integer cycleId = report.getCycleId();
        if (cycleId != null) {
            criteria.andCycleIdEqualTo(cycleId);
        }
        Integer periodId = report.getPeriodId();
        if (periodId != null) {
            criteria.andPeriodIdEqualTo(periodId);
        }
        Integer regionId = report.getRegionId();
        if (regionId != null) {
            criteria.andRegionIdEqualTo(regionId);
        }
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<Report> list = reportMapper.selectByExample(reportExample);
        return new PageInfo<Report>(list);
    }

    @Override
    public Report findReportByReportId(Integer reportId) {
        return reportMapper.selectByPrimaryKey(reportId);
    }

    @Override
    public int deleteByReportId(Integer reportId) {
        return reportMapper.deleteByPrimaryKey(reportId);
    }

    @Override
    public int updateByReportId(Report report) {
        return reportMapper.updateByPrimaryKeySelective(report);
    }

    @Override
    public int insert(Report report) {
        return reportMapper.insertSelective(report);
    }

}
