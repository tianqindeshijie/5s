package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.UpdateWorkCycleReportItem;
import com.chinamobile.iot.lightapp.mysql.model.ReportItem;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface ReportItemService {
    /**
     * 0--操作成功.
     */
    public static final int SUCCESS = 0;
    /**
     * 1--没有权限.
     */
    public static final int NO_PERMISSION = 1;

    /**
     * find reportItems.
     *
     * @param reportItem the reportItem
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the reportItems
     */
    public PageInfo<ReportItem> findReportItems(ReportItem reportItem, Integer pageNum, Integer pageSize);

    /**
     * find reportItem by reportItem id.
     *
     * @param reportItemId the reportItem id
     * @return the reportItem by reportItem id
     */
    public ReportItem findReportItemByReportItemId(Integer reportItemId);

    /**
     * Delete by reportItem id int.
     *
     * @param reportItemId the reportItem id
     * @return the int
     */
    @Transactional
    public int deleteByReportItemId(Integer reportItemId);

    /**
     * Update by reportItem id int.
     *
     * @param reportItem the reportItem
     * @return the int
     */
    @Transactional
    public int updateByReportItemId(ReportItem reportItem);

    /**
     * Insert int.
     *
     * @param reportItemList the report item list
     * @return the int
     */
    @Transactional
    public int insert(List<ReportItem> reportItemList);

    int updateWorkcycleReportItems(Integer userId, UpdateWorkCycleReportItem updateWorkCycleReportItem);
}
