package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.ReportItemScoreVO;
import com.chinamobile.iot.lightapp.mysql.model.ReportItemScore;
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
public interface ReportItemScoreService {


    /**
     * find reportItemScores.
     *
     * @param reportItemScore     the reportItemScore
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the reportItemScores
     */
    public PageInfo<ReportItemScoreVO> findReportItemScores(ReportItemScore reportItemScore, Integer pageNum, Integer pageSize);

    /**
     * find reportItemScore by reportItemScore id.
     *
     * @param reportItemScoreId the reportItemScore id
     * @return the reportItemScore by reportItemScore id
     */
    public ReportItemScore findReportItemScoreByReportItemScoreId(Integer reportItemScoreId);

    /**
     * Delete by reportItemScore id int.
     *
     * @param reportItemScoreId the reportItemScore id
     * @return the int
     */
    @Transactional
    public int deleteByReportItemScoreId(Integer reportItemScoreId);

    /**
     * Update by reportItemScore id int.
     *
     * @param reportItemScore the reportItemScore
     * @return the int
     */
    @Transactional
    public int updateByReportItemScoreId(ReportItemScore reportItemScore);

    /**
     * Insert int.
     *
     * @param reportItemScore the reportItemScore
     * @return the int
     */
    @Transactional
    public int insert(ReportItemScore reportItemScore);
}
