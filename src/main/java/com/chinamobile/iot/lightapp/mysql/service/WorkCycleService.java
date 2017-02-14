package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;
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
public interface WorkCycleService {


    /**
     * find workCycles.
     *
     * @param workCycle     the workCycle
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the workCycles
     */
    public PageInfo<WorkCycle> findWorkCycles(WorkCycle workCycle, Integer pageNum, Integer pageSize);

    /**
     * find workCycle by workCycle id.
     *
     * @param workCycleId the workCycle id
     * @return the workCycle by workCycle id
     */
    public WorkCycle findWorkCycleByWorkCycleId(Integer workCycleId);

    /**
     * Delete by workCycle id int.
     *
     * @param workCycleId the workCycle id
     * @return the int
     */
    @Transactional
    public int deleteByWorkCycleId(Integer workCycleId);

    /**
     * Update by workCycle id int.
     *
     * @param workCycle the workCycle
     * @return the int
     */
    @Transactional
    public int updateByWorkCycleId(WorkCycle workCycle);

    /**
     * Insert int.
     *
     * @param workCycle the workCycle
     * @return the int
     */
    @Transactional
    public int insert(WorkCycle workCycle);
}
