package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.NoticeMapper;
import com.chinamobile.iot.lightapp.mysql.dao.NoticeMapperExt;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dto.NoticeDTO;
import com.chinamobile.iot.lightapp.mysql.model.Notice;
import com.chinamobile.iot.lightapp.mysql.model.NoticeExample;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycleExample;
import com.chinamobile.iot.lightapp.mysql.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeMapperExt noticeMapperExt;
    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;
    @Override
    public PageInfo<NoticeDTO> findNotices(Notice notice, Integer userId, Integer pageNum, Integer pageSize) {
        //查询用户所有的工作圈
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        List<Integer> workCycleList = new ArrayList<Integer>();
        if (list != null && list.size() > 0) {
            for (UserWorkcycle temp : list) {
                workCycleList.add(temp.getWorkCycleId());
            }
        }

        //查看所在工作圈的所有公告
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria1 = noticeExample.createCriteria();
        criteria1.andCycleIdIn(workCycleList);

        PageHelper.startPage(pageNum, pageSize, true, false);
        List<NoticeDTO> noticeList = noticeMapperExt.selectByExample(noticeExample);
        return new PageInfo<NoticeDTO>(noticeList);
    }

    @Override
    public Notice findNoticeByNoticeId(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Override
    public int deleteByNoticeId(Integer noticeId) {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }

    @Override
    public int updateByNoticeId(Notice notice) {
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int insert(Notice notice) {
        return noticeMapper.insertSelective(notice);
    }

}
