package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.NoticeDTO;
import com.chinamobile.iot.lightapp.mysql.model.Notice;
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
public interface NoticeService {


    /**
     * find notices.
     *
     * @param notice   the notice
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the notices
     */
    public PageInfo<NoticeDTO> findNotices(Notice notice, Integer userId, Integer pageNum, Integer pageSize);

    /**
     * find notice by notice id.
     *
     * @param noticeId the notice id
     * @return the notice by notice id
     */
    public Notice findNoticeByNoticeId(Integer noticeId);

    /**
     * Delete by notice id int.
     *
     * @param noticeId the notice id
     * @return the int
     */
    @Transactional
    public int deleteByNoticeId(Integer noticeId);

    /**
     * Update by notice id int.
     *
     * @param notice the notice
     * @return the int
     */
    @Transactional
    public int updateByNoticeId(Notice notice);

    /**
     * Insert int.
     *
     * @param notice the notice
     * @return the int
     */
    @Transactional
    public int insert(Notice notice);
}
