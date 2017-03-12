package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.dto.PeriodDTO;
import com.chinamobile.iot.lightapp.mysql.model.Period;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
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
@Api("时间段管理")
public class PeriodController {
    private static Logger logger = LoggerFactory.getLogger(PeriodController.class);
    @Autowired
    private PeriodService periodService;

    /**
     * 根据指定periodId查询时间段信息
     *
     * @param periodId the period id
     * @return the period by period id
     */
    @RequestMapping(path = "/periods/{periodId}", method = RequestMethod.GET)
    public Period getPeriodByPeriodId(@PathVariable("periodId") Integer periodId) {
        return periodService.findPeriodByPeriodId(periodId);
    }

    /**
     * 根据指定参数查询时间段信息列表
     *
     * @param periodName the period name
     * @param cycleId    the cycle id
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the periods
     */
    @RequestMapping(value = "/periods", method = RequestMethod.GET)
    public BaseResponse getPeriods(@RequestParam(value = "periodName", required = false) String periodName,
                                          @RequestParam(value = "cycleId", required = false) Integer cycleId,
                                          @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        Integer userId = SecurityUtils.getCurrentUserId();
        Period period = new Period();
        period.setPeriodName(periodName);
        period.setCycleId(cycleId);
        PageInfo<PeriodDTO> pageInfo = periodService.findPeriods(period, userId, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增时间段信息.
     *
     * @param period the add period request
     * @return the integer
     */
    @RequestMapping(value = "/periods", method = RequestMethod.POST)
    public BaseResponse addPeriod(@RequestBody Period period) {
        periodService.insert(period);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新时间段信息.
     *
     * @param period the update period request
     * @return the integer
     */
    @RequestMapping(value = "/periods", method = RequestMethod.PUT)
    public BaseResponse updatePeriod(@RequestBody Period period) {
        periodService.updateByPeriodId(period);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的periodId删除时间段信息
     *
     * @param periodId the period id
     * @return the integer
     */
    @RequestMapping(value = "/periods/{periodId}", method = RequestMethod.DELETE)
    public BaseResponse deletePeriod(@PathVariable("periodId") Integer periodId) {
        periodService.deleteByPeriodId(periodId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        return response;
    }

}
