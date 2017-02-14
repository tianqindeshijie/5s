package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;
import com.chinamobile.iot.lightapp.mysql.service.WorkCycleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController
@RequestMapping("/mysql")
@Api("模板管理")
public class WorkCycleController {
    private static Logger logger = LoggerFactory.getLogger(WorkCycleController.class);
    @Autowired
    private WorkCycleService workCycleService;

    /**
     * 根据指定workCycleId查询模板信息
     *
     * @param workCycleId the workCycle id
     * @return the workCycle by workCycle id
     */
    @RequestMapping(path = "/workCycles/{workCycleId}", method = RequestMethod.GET)
    public WorkCycle getWorkCycleByWorkCycleId(@PathVariable("workCycleId") Integer workCycleId) {
        return workCycleService.findWorkCycleByWorkCycleId(workCycleId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param workCycleName    the workCycle name
     * @param workCycleContent the workCycle content
     * @param workCycleType    the workCycle type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the workCycles
     */

    @RequestMapping(value = "/workCycles", method = RequestMethod.GET)
    public PageInfo<WorkCycle> getWorkCycles(@RequestParam(value = "workCycleName", required = false) String workCycleName,
                                           @RequestParam(value = "workCycleContent", required = false) String workCycleContent,
                                           @RequestParam(value = "workCycleType", required = false) Integer workCycleType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        WorkCycle workCycle = new WorkCycle();

        return workCycleService.findWorkCycles(workCycle, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param workCycle the add workCycle request
     * @return the integer
     */
    @RequestMapping(value = "/workCycles", method = RequestMethod.POST)
    public Integer addWorkCycle(@RequestBody WorkCycle workCycle) {
        return workCycleService.insert(workCycle);
    }

    /**
     * 更新模板信息.
     *
     * @param workCycle the update workCycle request
     * @return the integer
     */
    @RequestMapping(value = "/workCycles", method = RequestMethod.PUT)
    public Integer updateWorkCycle(@RequestBody WorkCycle workCycle) {
        return workCycleService.updateByWorkCycleId(workCycle);
    }

    /**
     * 根据指定的workCycleId删除模板信息
     *
     * @param workCycleId the workCycle id
     * @return the integer
     */
    @RequestMapping(value = "/workCycles/{workCycleId}", method = RequestMethod.DELETE)
    public Integer deleteWorkCycle(@PathVariable("workCycleId") Integer workCycleId) {
        return workCycleService.deleteByWorkCycleId(workCycleId);
    }

}
