package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Apply;
import com.chinamobile.iot.lightapp.mysql.service.ApplyService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
@Api("申请管理")
public class ApplyController {
    private static Logger logger = LoggerFactory.getLogger(ApplyController.class);
    @Autowired
    private ApplyService applyService;

    /**
     * 根据指定applyId查询申请信息
     *
     * @param applyId the apply id
     * @return the apply by apply id
     */
    @RequestMapping(path = "/applys/{applyId}", method = RequestMethod.GET)
    public Apply getApplyByApplyId(@PathVariable("applyId") Integer applyId) {
        return applyService.findApplyByApplyId(applyId);
    }

    /**
     * 根据指定参数查询申请信息列表
     *
     * @param applyName    the apply name
     * @param applyContent the apply content
     * @param applyType    the apply type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the applys
     */

    @RequestMapping(value = "/applys", method = RequestMethod.GET)
    public PageInfo<Apply> getApplys(@RequestParam(value = "applyName", required = false) String applyName,
                                           @RequestParam(value = "applyContent", required = false) String applyContent,
                                           @RequestParam(value = "applyType", required = false) Integer applyType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Apply apply = new Apply();

        return applyService.findApplys(apply, pageNum, pageSize);
    }

    /**
     * 新增申请信息.
     *
     * @param apply the add apply request
     * @return the integer
     */
    @RequestMapping(value = "/applys", method = RequestMethod.POST)
    public Integer addApply(@RequestBody Apply apply) {
        return applyService.insert(apply);
    }

    /**
     * 更新申请信息.
     *
     * @param apply the update apply request
     * @return the integer
     */
    @RequestMapping(value = "/applys", method = RequestMethod.PUT)
    public Integer updateApply(@RequestBody Apply apply) {
        return applyService.updateByApplyId(apply);
    }

    /**
     * 根据指定的applyId删除申请信息
     *
     * @param applyId the apply id
     * @return the integer
     */
    @RequestMapping(value = "/applys/{applyId}", method = RequestMethod.DELETE)
    public Integer deleteApply(@PathVariable("applyId") Integer applyId) {
        return applyService.deleteByApplyId(applyId);
    }

}
