package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.CheckItemScore;
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
public interface CheckItemScoreService {


    /**
     * find checkItemScores.
     *
     * @param checkItemScore the checkItemScore
     * @param pageNum        the page num
     * @param pageSize       the page size
     * @return the checkItemScores
     */
    public PageInfo<CheckItemScore> findCheckItemScores(CheckItemScore checkItemScore, Integer pageNum, Integer pageSize);

    /**
     * find checkItemScore by checkItemScore id.
     *
     * @param checkItemScoreId the checkItemScore id
     * @return the checkItemScore by checkItemScore id
     */
    public CheckItemScore findCheckItemScoreByCheckItemScoreId(Integer checkItemScoreId);

    /**
     * Delete by checkItemScore id int.
     *
     * @param checkItemScoreId the checkItemScore id
     * @return the int
     */
    @Transactional
    public int deleteByCheckItemScoreId(Integer checkItemScoreId);

    /**
     * Update by checkItemScore id int.
     *
     * @param checkItemScore the checkItemScore
     * @return the int
     */
    @Transactional
    public int updateByCheckItemScoreId(CheckItemScore checkItemScore);

    /**
     * Insert int.
     *
     * @param checkItemScore the checkItemScore
     * @return the int
     */
    @Transactional
    public int insert(CheckItemScore checkItemScore);
}
