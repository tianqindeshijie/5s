package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.ReportItemMapper;
import com.chinamobile.iot.lightapp.mysql.model.ReportItem;
import com.chinamobile.iot.lightapp.mysql.model.ReportItemExample;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemService;
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
public class ReportItemServiceImpl implements ReportItemService {

    @Autowired
    private ReportItemMapper reportItemMapper;

    @Override
    public PageInfo<ReportItem> findReportItems(ReportItem reportItem, Integer pageNum, Integer pageSize) {
        ReportItemExample reportItemExample = new ReportItemExample();
        ReportItemExample.Criteria criteria = reportItemExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<ReportItem> list= reportItemMapper.selectByExample(reportItemExample);
        return new PageInfo<ReportItem>(list);
    }

    @Override
    public ReportItem findReportItemByReportItemId(Integer reportItemId) {
        return reportItemMapper.selectByPrimaryKey(reportItemId);
    }

    @Override
    public int deleteByReportItemId(Integer reportItemId) {
        return reportItemMapper.deleteByPrimaryKey(reportItemId);
    }

    @Override
    public int updateByReportItemId(ReportItem reportItem) {
        return reportItemMapper.updateByPrimaryKeySelective(reportItem);
    }

    @Override
    public int insert(ReportItem reportItem) {
        return reportItemMapper.insertSelective(reportItem);
    }

}
