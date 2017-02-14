package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Period;
import com.chinamobile.iot.lightapp.mysql.service.PeriodService;
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
public class PeriodController {
    private static Logger logger = LoggerFactory.getLogger(PeriodController.class);
    @Autowired
    private PeriodService periodService;

    /**
     * 根据指定periodId查询模板信息
     *
     * @param periodId the period id
     * @return the period by period id
     */
    @RequestMapping(path = "/periods/{periodId}", method = RequestMethod.GET)
    public Period getPeriodByPeriodId(@PathVariable("periodId") Integer periodId) {
        return periodService.findPeriodByPeriodId(periodId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param periodName    the period name
     * @param periodContent the period content
     * @param periodType    the period type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the periods
     */

    @RequestMapping(value = "/periods", method = RequestMethod.GET)
    public PageInfo<Period> getPeriods(@RequestParam(value = "periodName", required = false) String periodName,
                                           @RequestParam(value = "periodContent", required = false) String periodContent,
                                           @RequestParam(value = "periodType", required = false) Integer periodType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Period period = new Period();

        return periodService.findPeriods(period, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param period the add period request
     * @return the integer
     */
    @RequestMapping(value = "/periods", method = RequestMethod.POST)
    public Integer addPeriod(@RequestBody Period period) {
        return periodService.insert(period);
    }

    /**
     * 更新模板信息.
     *
     * @param period the update period request
     * @return the integer
     */
    @RequestMapping(value = "/periods", method = RequestMethod.PUT)
    public Integer updatePeriod(@RequestBody Period period) {
        return periodService.updateByPeriodId(period);
    }

    /**
     * 根据指定的periodId删除模板信息
     *
     * @param periodId the period id
     * @return the integer
     */
    @RequestMapping(value = "/periods/{periodId}", method = RequestMethod.DELETE)
    public Integer deletePeriod(@PathVariable("periodId") Integer periodId) {
        return periodService.deleteByPeriodId(periodId);
    }

}
