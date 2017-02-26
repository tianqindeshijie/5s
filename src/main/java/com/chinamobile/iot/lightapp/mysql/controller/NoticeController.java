package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Notice;
import com.chinamobile.iot.lightapp.mysql.service.NoticeService;
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
    @RequestMapping(path = "/notices/{noticeId}", method = RequestMethod.GET)
    public Notice getNoticeByNoticeId(@PathVariable("noticeId") Integer noticeId) {
        return noticeService.findNoticeByNoticeId(noticeId);
    }

    /**
     * 根据指定参数查询公告信息列表
     *
     * @param noticeName    the notice name
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the notices
     */

    @RequestMapping(value = "/notices", method = RequestMethod.GET)
    public PageInfo<Notice> getNotices(@RequestParam(value = "noticeName", required = false) String noticeName,
                                           @RequestParam(value = "noticeType", required = false) Integer noticeType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Notice notice = new Notice();

        return noticeService.findNotices(notice, pageNum, pageSize);
    }

    /**
     * 新增公告信息.
     *
     * @param notice the add notice request
     * @return the integer
     */
    @RequestMapping(value = "/notices", method = RequestMethod.POST)
    public Integer addNotice(@RequestBody Notice notice) {
        return noticeService.insert(notice);
    }

    /**
     * 更新公告信息.
     *
     * @param notice the update notice request
     * @return the integer
     */
    @RequestMapping(value = "/notices", method = RequestMethod.PUT)
    public Integer updateNotice(@RequestBody Notice notice) {
        return noticeService.updateByNoticeId(notice);
    }

    /**
     * 根据指定的noticeId删除公告信息
     *
     * @param noticeId the notice id
     * @return the integer
     */
    @RequestMapping(value = "/notices/{noticeId}", method = RequestMethod.DELETE)
    public Integer deleteNotice(@PathVariable("noticeId") Integer noticeId) {
        return noticeService.deleteByNoticeId(noticeId);
    }

}
