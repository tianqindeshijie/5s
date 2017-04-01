package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.WorkCycleDTO;
import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;
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
public interface WorkCycleService {
    /**
     * 0--操作成功.
     */
    public static final int SUCCESS = 0;
    /**
     * 1--没有权限.
     */
    public static final int NO_PERMISSION = 1;


    /**
     * find workCycles.
     *
     * @param workCycle the workCycle
     * @param pageNum   the page num
     * @param pageSize  the page size
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
     * @param userId      the user id
     * @param workCycleId the workCycle id
     * @return the int
     */
    @Transactional
    public int deleteByWorkCycleId(Integer userId, Integer workCycleId);

    /**
     * Update by workCycle id int.
     *
     * @param userId    the user id
     * @param workCycle the workCycle
     * @return the int
     */
    @Transactional
    public int updateByWorkCycleId(Integer userId, WorkCycle workCycle);

    /**
     * Insert int.
     *
     * @param userId     the user id
     * @param workCycle  the workCycle
     * @param regionList the region list
     * @return the int
     */
    @Transactional
    int insert(Integer userId, WorkCycle workCycle, List<Region> regionList);

    /**
     * Find work cycle by user id work cycle.
     *
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the work cycle
     */
    public PageInfo<WorkCycleDTO> findWorkCycleByUserId(Integer userId, Integer pageNum, Integer pageSize);
}
