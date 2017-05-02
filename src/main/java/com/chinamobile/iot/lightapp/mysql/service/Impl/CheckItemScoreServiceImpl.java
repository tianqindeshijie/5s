package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.CheckItemMapper;
import com.chinamobile.iot.lightapp.mysql.dao.CheckItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.dao.ReportItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class CheckItemScoreServiceImpl implements CheckItemScoreService {

    @Autowired
    private CheckItemScoreMapper checkItemScoreMapper;

    @Autowired
    private CheckItemMapper checkItemMapper;
    @Autowired
    private ReportItemScoreMapper reportItemScoreMapper;

    @Override
    public PageInfo<CheckItemScore> findCheckItemScores(Integer reportItemId, Integer reportId, Integer pageNum, Integer pageSize) {
        ReportItemScoreExample reportItemScoreExample = new ReportItemScoreExample();
        ReportItemScoreExample.Criteria criteria = reportItemScoreExample.createCriteria();
        criteria.andReportIdEqualTo(reportId);
        criteria.andReportItemIdEqualTo(reportItemId);
        List<ReportItemScore> reportItemScoreList = reportItemScoreMapper.selectByExample(reportItemScoreExample);
        List<Integer> reportItemScoreIdList = new ArrayList<Integer>();
        if (CollectionUtils.isEmpty(reportItemScoreList)) {
            return null;
        } else {
            for (ReportItemScore temp : reportItemScoreList) {
                reportItemScoreIdList.add(temp.getReportItemScoreId());
            }
        }
        CheckItemScoreExample checkItemScoreExample = new CheckItemScoreExample();
        CheckItemScoreExample.Criteria criteria1 = checkItemScoreExample.createCriteria();
        criteria1.andReportItemScoreIdIn(reportItemScoreIdList);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<CheckItemScore> list = checkItemScoreMapper.selectByExample(checkItemScoreExample);
        return new PageInfo<CheckItemScore>(list);
    }

    @Override
    public CheckItemScore findCheckItemScoreByCheckItemScoreId(Integer checkItemScoreId) {
        return checkItemScoreMapper.selectByPrimaryKey(checkItemScoreId);
    }

    @Override
    public int deleteByCheckItemScoreId(Integer checkItemScoreId) {
        return checkItemScoreMapper.deleteByPrimaryKey(checkItemScoreId);
    }

    @Override
    public int updateByCheckItemScoreId(CheckItemScore checkItemScore) {
        return checkItemScoreMapper.updateByPrimaryKeySelective(checkItemScore);
    }

    @Override
    public int insert(List<CheckItemScore> checkItemScoreList) {
        int sumScore = 0;
        Integer reportId = null;
        Integer reportItemId = null;
        List<ScoreBean> scoreBeanList = new ArrayList<ScoreBean>();
        if (!CollectionUtils.isEmpty(checkItemScoreList)) {
            for (CheckItemScore temp : checkItemScoreList) {
                checkItemScoreMapper.insertSelective(temp);
                CheckItem checkItem = checkItemMapper.selectByPrimaryKey(temp.getCheckItemId());
                ScoreBean scoreBean = new ScoreBean();
                scoreBean.setItemId(checkItem.getItemId());
                scoreBean.setPriority(checkItem.getPriority());
                scoreBean.setScore(temp.getScore());
                scoreBeanList.add(scoreBean);
                sumScore = sumScore + temp.getScore();
                reportId = temp.getReportId();
                reportItemId = checkItem.getItemId();
            }
        } else {
            throw new RuntimeException("no checkItemScore in the list!");
        }
        int sScore = compute5SScore(scoreBeanList);
        ReportItemScore reportItemScore = new ReportItemScore();
        reportItemScore.setReportId(reportId);
        reportItemScore.setReportItemId(reportItemId);
        reportItemScore.setScore(sumScore);
        reportItemScore.setsScore(sScore);
        reportItemScoreMapper.insertSelective(reportItemScore);
        return 0;
    }

    private class ScoreBean {
        private int priority;
        private int score;
        private int itemId;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }
    }

    public int compute5SScore(List<ScoreBean> scorelist) {
        int score = 0;
        Collections.sort(scorelist, new Comparator<ScoreBean>() {
            @Override
            public int compare(ScoreBean lhs, ScoreBean rhs) {
                if (lhs.priority < rhs.priority)
                    return -1;
                else if (lhs.priority > rhs.priority) {
                    return 1;
                } else
                    return 0;
            }
        });

        for (int i = 0; i < scorelist.size(); i++) {
            int s = scorelist.get(i).getScore();
            if (s < 5) {
                break;
            } else {
                score++;
            }
        }
        return score;
    }

}
