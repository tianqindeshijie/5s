package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.alibaba.fastjson.JSON;
import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.*;
import com.chinamobile.iot.lightapp.mysql.dto.CheckItemScoreDTO;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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
    private CheckItemScoreMapperExt checkItemScoreMapperExt;
    @Autowired
    private CheckItemMapper checkItemMapper;
    @Autowired
    private ReportItemScoreMapper reportItemScoreMapper;
    @Autowired
    private PhotoMapper photoMapper;
    @Value("${5s.file.path}")
    private String filePath;

    /**
     * Gets file path.
     *
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets file path.
     *
     * @param filePath the file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public PageInfo<CheckItemScoreDTO> findCheckItemScores(Integer reportItemId, Integer reportId, Integer pageNum, Integer pageSize) {
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
        List<CheckItemScoreDTO> list = checkItemScoreMapperExt.selectByExample(checkItemScoreExample);
        return new PageInfo<CheckItemScoreDTO>(list);
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
    public int insert(Integer reportId, Integer reportItemId, List<CheckItemScore> checkItemScoreList,MultipartFile[] multipartFiles) {
        int sumScore = 0;
        List<ScoreBean> scoreBeanList = new ArrayList<ScoreBean>();
        if (!CollectionUtils.isEmpty(checkItemScoreList)) {
            for (CheckItemScore temp : checkItemScoreList) {
                CheckItem checkItem = checkItemMapper.selectByPrimaryKey(temp.getCheckItemId());
                if (checkItem == null) {
                    throw new RuntimeException("Can not find this checkItem!");
                }
                ScoreBean scoreBean = new ScoreBean();
                scoreBean.setItemId(checkItem.getItemId());
                scoreBean.setPriority(checkItem.getPriority());
                scoreBean.setScore(temp.getScore());
                scoreBeanList.add(scoreBean);
                sumScore = sumScore + temp.getScore();
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
        Integer reportItemScoreId = reportItemScore.getReportItemScoreId();
        if (!CollectionUtils.isEmpty(checkItemScoreList)) {
            for (CheckItemScore temp : checkItemScoreList) {
                temp.setReportId(reportId);
                temp.setReportItemScoreId(reportItemScoreId);
                checkItemScoreMapper.insertSelective(temp);
            }
        }
        saveReportItemPhoto(reportItemScore.getReportItemScoreId(),multipartFiles);
        return 0;
    }

    /**
     * Save report item photo.
     *
     * @param reportItemScoreId the report item score id
     * @param multipartFiles    the multipart files
     */
    private void saveReportItemPhoto(Integer reportItemScoreId, MultipartFile[] multipartFiles) {
        List<Integer> photoIds = new ArrayList<Integer>();
        //保存文件,并插入记录到Photo表
        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = saveUploadedFiles(multipartFile);
            Photo photo = new Photo();
            photo.setPhotoAddr(fileName);
            photo.setPhotoType(Constant.PHOTO_TYPE_CHECK);
            photoMapper.insert(photo);
            photoIds.add(photo.getPhotoId());
        }
        String photoIdJson = JSON.toJSONString(photoIds);
        ReportItemScore reportItemScore = new ReportItemScore();
        reportItemScore.setReportItemScoreId(reportItemScoreId);
        reportItemScore.setPhotoIds(photoIdJson);
        reportItemScoreMapper.updateByPrimaryKeySelective(reportItemScore);
    }

    /**
     * Save uploaded files string.
     *
     * @param multipartFile the multipart file
     * @return the string
     */
    private String saveUploadedFiles(MultipartFile multipartFile) {
        BufferedOutputStream out = null;
        if (multipartFile != null && !multipartFile.isEmpty()) {
            try {
                /**获取文件的后缀**/
                String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
                /**使用UUID生成文件名称**/
                String logImageName = UUID.randomUUID().toString() + suffix;
                /**拼成完整的文件保存路径加文件**/
                String fileName = filePath + File.separator + logImageName;
                File file = new File(fileName);
                multipartFile.transferTo(file);
                return fileName;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("file is empty!");
    }

    private class ScoreBean {
        private int priority;
        private int score;
        private int itemId;

        /**
         * Gets priority.
         *
         * @return the priority
         */
        public int getPriority() {
            return priority;
        }

        /**
         * Sets priority.
         *
         * @param priority the priority
         */
        public void setPriority(int priority) {
            this.priority = priority;
        }

        /**
         * Gets score.
         *
         * @return the score
         */
        public int getScore() {
            return score;
        }

        /**
         * Sets score.
         *
         * @param score the score
         */
        public void setScore(int score) {
            this.score = score;
        }

        /**
         * Gets item id.
         *
         * @return the item id
         */
        public int getItemId() {
            return itemId;
        }

        /**
         * Sets item id.
         *
         * @param itemId the item id
         */
        public void setItemId(int itemId) {
            this.itemId = itemId;
        }
    }

    /**
     * Compute 5 s score int.
     *
     * @param scorelist the scorelist
     * @return the int
     */
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
