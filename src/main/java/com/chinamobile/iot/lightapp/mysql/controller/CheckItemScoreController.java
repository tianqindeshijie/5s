package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.CheckItemScore;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemScoreService;
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
public class CheckItemScoreController {
    private static Logger logger = LoggerFactory.getLogger(CheckItemScoreController.class);
    @Autowired
    private CheckItemScoreService checkItemScoreService;

    /**
     * 根据指定checkItemScoreId查询模板信息
     *
     * @param checkItemScoreId the checkItemScore id
     * @return the checkItemScore by checkItemScore id
     */
    @RequestMapping(path = "/checkItemScores/{checkItemScoreId}", method = RequestMethod.GET)
    public CheckItemScore getCheckItemScoreByCheckItemScoreId(@PathVariable("checkItemScoreId") Integer checkItemScoreId) {
        return checkItemScoreService.findCheckItemScoreByCheckItemScoreId(checkItemScoreId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param reportItemScoreId the report item score id
     * @param pageNum           the page num
     * @param pageSize          the page size
     * @return the checkItemScores
     */
    @RequestMapping(value = "/checkItemScores", method = RequestMethod.GET)
    public BaseResponse getCheckItemScores(@RequestParam(value = "reportItemScoreId", required = true) Integer reportItemScoreId,
                                      @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        CheckItemScore checkItemScore = new CheckItemScore();
        checkItemScore.setReportItemScoreId(reportItemScoreId);
        PageInfo<CheckItemScore> pageInfo = checkItemScoreService.findCheckItemScores(checkItemScore, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增模板信息.
     *
     * @param checkItemScore the add checkItemScore request
     * @return the integer
     */
    @RequestMapping(value = "/checkItemScores", method = RequestMethod.POST)
    public BaseResponse addCheckItemScore(@RequestBody CheckItemScore checkItemScore) {
        checkItemScoreService.insert(checkItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新模板信息.
     *
     * @param checkItemScore the update checkItemScore request
     * @return the integer
     */
    @RequestMapping(value = "/checkItemScores", method = RequestMethod.PUT)
    public BaseResponse updateCheckItemScore(@RequestBody CheckItemScore checkItemScore) {
        checkItemScoreService.updateByCheckItemScoreId(checkItemScore);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的checkItemScoreId删除模板信息
     *
     * @param checkItemScoreId the checkItemScore id
     * @return the integer
     */
    @RequestMapping(value = "/checkItemScores/{checkItemScoreId}", method = RequestMethod.DELETE)
    public BaseResponse deleteCheckItemScore(@PathVariable("checkItemScoreId") Integer checkItemScoreId) {
        checkItemScoreService.deleteByCheckItemScoreId(checkItemScoreId);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

}
