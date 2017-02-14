package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.ReportItem;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface ReportItemService {


    /**
     * find reportItems.
     *
     * @param reportItem     the reportItem
     * @param pageNum  the page num
     * @param pageSize the page size
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
     * @param reportItem the reportItem
     * @return the int
     */
    @Transactional
    public int insert(ReportItem reportItem);
}
