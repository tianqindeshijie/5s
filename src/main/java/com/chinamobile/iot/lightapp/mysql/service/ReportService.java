package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.Report;
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
public interface ReportService {


    /**
     * find reports.
     *
     * @param report     the report
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the reports
     */
    public PageInfo<Report> findReports(Report report, Integer pageNum, Integer pageSize);

    /**
     * find report by report id.
     *
     * @param reportId the report id
     * @return the report by report id
     */
    public Report findReportByReportId(Integer reportId);

    /**
     * Delete by report id int.
     *
     * @param reportId the report id
     * @return the int
     */
    @Transactional
    public int deleteByReportId(Integer reportId);

    /**
     * Update by report id int.
     *
     * @param report the report
     * @return the int
     */
    @Transactional
    public int updateByReportId(Report report);

    /**
     * Insert int.
     *
     * @param report the report
     * @return the int
     */
    @Transactional
    public int insert(Report report);
}
