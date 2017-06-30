package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.CheckItemMapper;
import com.chinamobile.iot.lightapp.mysql.dao.ReportItemMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dto.ReportItemDTO;
import com.chinamobile.iot.lightapp.mysql.dto.UpdateWorkCycleReportItem;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.service.ReportItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public PageInfo<ReportItem> findReportItems(ReportItem reportItem, Integer pageNum, Integer pageSize) {
        ReportItemExample reportItemExample = new ReportItemExample();
        ReportItemExample.Criteria criteria = reportItemExample.createCriteria();
        Integer cycleId = reportItem.getCycleId();
        criteria.andCycleIdEqualTo(cycleId);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<ReportItem> list = reportItemMapper.selectByExample(reportItemExample);
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
    public int insert(List<ReportItem> reportItemList) {
        if (CollectionUtils.isEmpty(reportItemList)) {
            throw new RuntimeException("no report item to add!");
        }
        for (ReportItem reportItem : reportItemList) {
            reportItemMapper.insertSelective(reportItem);
        }
        return 0;
    }

    @Override
    public int updateWorkcycleReportItems(Integer userId, UpdateWorkCycleReportItem updateWorkCycleReportItem) {
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(updateWorkCycleReportItem.getWorkCycleId());
        criteria.andUserIdEqualTo(userId);
        criteria.andIsManagerNotEqualTo(Constant.CYCLE_MEMBER);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (list == null && list.size() == 0) {
            return NO_PERMISSION;
        }
        List<ReportItemDTO> regionList = updateWorkCycleReportItem.getReportItemList();
        for (ReportItemDTO temp : regionList) {
            int operateType = temp.getOperateType();
            if (operateType == Constant.OPERATE_TYPE_ADD) {
                reportItemMapper.insert(temp);
            } else if (operateType == Constant.OPERATE_TYPE_UPDATE) {
                reportItemMapper.updateByPrimaryKeySelective(temp);
            } else if (operateType == Constant.OPERATE_TYPE_DELETE) {
                reportItemMapper.deleteByPrimaryKey(temp.getItemId());
                //删除对于的检查小项
                CheckItemExample checkItemExample = new CheckItemExample();
                CheckItemExample.Criteria criteria1 = checkItemExample.createCriteria();
                criteria1.andItemIdEqualTo(temp.getItemId());
                checkItemMapper.deleteByExample(checkItemExample);
            }
        }
        return SUCCESS;
    }
}
