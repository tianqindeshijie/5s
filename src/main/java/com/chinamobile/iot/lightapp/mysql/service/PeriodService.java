package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.PeriodDTO;
import com.chinamobile.iot.lightapp.mysql.model.Period;
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
public interface PeriodService {


    /**
     * find periods.
     *
     * @param period   the period
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the periods
     */
    public PageInfo<PeriodDTO> findPeriods(Period period, Integer userId, Integer pageNum, Integer pageSize);

    /**
     * find period by period id.
     *
     * @param periodId the period id
     * @return the period by period id
     */
    public Period findPeriodByPeriodId(Integer periodId);

    /**
     * Delete by period id int.
     *
     * @param periodId the period id
     * @return the int
     */
    @Transactional
    public int deleteByPeriodId(Integer periodId);

    /**
     * Update by period id int.
     *
     * @param period the period
     * @return the int
     */
    @Transactional
    public int updateByPeriodId(Period period);

    /**
     * Insert int.
     *
     * @param period the period
     * @return the int
     */
    @Transactional
    public int insert(Period period);
}
