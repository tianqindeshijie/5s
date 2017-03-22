package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.security.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.dto.NoticeDTO;
import com.chinamobile.iot.lightapp.mysql.model.Notice;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.NoticeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("公告管理")
public class NoticeController {
    private static Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    private NoticeService noticeService;

    /**
     * 根据指定noticeId查询公告信息
     *
     * @param noticeId the notice id
     * @return the notice by notice id
     */
    @ApiOperation(value = "查询公告", notes = "查询公告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "noticeId", required = true, value = "公告ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/notices/{noticeId}", method = RequestMethod.GET)
    public Notice getNoticeByNoticeId(@PathVariable("noticeId") Integer noticeId) {
        return noticeService.findNoticeByNoticeId(noticeId);
    }

    /**
     * 根据指定参数查询公告信息列表
     *
     * @return the notices
     */
    @ApiOperation(value = "查询公告列表", notes = "查询公告列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/notices", method = RequestMethod.GET)
    public PageInfo<NoticeDTO> getNotices() {
        Notice notice = new Notice();
        Integer userId = SecurityUtils.getCurrentUserId();
        return noticeService.findNotices(notice, userId, 1, 0);
    }

    /**
     * 新增公告信息.
     *
     * @param notice the add notice request
     * @return the integer
     */
    @ApiOperation(value = "新增公告", notes = "新增公告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/notices", method = RequestMethod.POST)
    public BaseResponse addNotice(@RequestBody Notice notice) {
        noticeService.insert(notice);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新公告信息.
     *
     * @param notice the update notice request
     * @return the integer
     */
    @ApiOperation(value = "更新公告", notes = "更新公告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/notices", method = RequestMethod.PUT)
    public BaseResponse updateNotice(@RequestBody Notice notice) {
        noticeService.updateByNoticeId(notice);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的noticeId删除公告信息
     *
     * @param noticeId the notice id
     * @return the integer
     */
    @ApiOperation(value = "删除公告", notes = "删除公告")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "noticeId", required = true, value = "公告ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/notices/{noticeId}", method = RequestMethod.DELETE)
    public BaseResponse deleteNotice(@PathVariable("noticeId") Integer noticeId) {
        noticeService.deleteByNoticeId(noticeId);
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMsg("成功!");
        return response;
    }

}
