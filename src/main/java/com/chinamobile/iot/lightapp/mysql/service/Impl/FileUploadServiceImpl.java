package com.chinamobile.iot.lightapp.mysql.service.Impl;

import com.alibaba.fastjson.JSON;
import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.PhotoMapper;
import com.chinamobile.iot.lightapp.mysql.dao.ReportItemScoreMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserMapper;
import com.chinamobile.iot.lightapp.mysql.dao.WorkCycleMapper;
import com.chinamobile.iot.lightapp.mysql.model.Photo;
import com.chinamobile.iot.lightapp.mysql.model.ReportItemScore;
import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;
import com.chinamobile.iot.lightapp.mysql.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by xuetao on 2017/5/23.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ReportItemScoreMapper reportItemScoreMapper;

    @Autowired
    private WorkCycleMapper workCycleMapper;
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

    /**
     * 保存用户头像
     *
     * @param userId        the user id
     * @param multipartFile the multipart file
     */
    @Override
    public void saveUserPhoto(Integer userId, MultipartFile multipartFile) {
        //保存文件
        String fileName = saveUploadedFiles(multipartFile);
        Photo photo = new Photo();
        //查询用户原来照片ID。为删除旧照片做准备
        String oldFilePath = null;
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null && user.getPhotoId() != null) {
            photo = photoMapper.selectByPrimaryKey(user.getPhotoId());
            oldFilePath = photo.getPhotoAddr();
            photo.setPhotoAddr(fileName);
            photoMapper.updateByPrimaryKeySelective(photo);
        } else {
            photo.setPhotoAddr(fileName);
            photo.setPhotoType(Constant.PHOTO_TYPE_USER);
            photoMapper.insert(photo);
            User newUser = new User();
            newUser.setUserId(userId);
            newUser.setPhotoId(photo.getPhotoId());
            userMapper.updateByPrimaryKeySelective(newUser);
        }
        //删除源文件
        try {
            if (oldFilePath != null && oldFilePath.trim().length() > 0) {
                File file = new File(oldFilePath);
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {

        }

    }

    /**
     * 保存工作圈头像.
     *
     * @param workcycleId   the workcycle id
     * @param multipartFile the multipart file
     */
    @Override
    public void saveWorkcyclePhoto(Integer workcycleId, MultipartFile multipartFile) {
        //保存文件
        String fileName = saveUploadedFiles(multipartFile);
        Photo photo = new Photo();
        //查询工作圈原来照片ID。为删除旧照片做准备
        String oldFilePath = null;
        WorkCycle workCycle = workCycleMapper.selectByPrimaryKey(workcycleId);
        if (workCycle != null && workCycle.getPhotoId() != null) {
            photo = photoMapper.selectByPrimaryKey(workCycle.getPhotoId());
            oldFilePath = photo.getPhotoAddr();
            photo.setPhotoAddr(fileName);
            photoMapper.updateByPrimaryKeySelective(photo);
        } else {
            photo.setPhotoAddr(fileName);
            photo.setPhotoType(Constant.PHOTO_TYPE_WORKCYCLE);
            photoMapper.insert(photo);
            WorkCycle newWorkCycle = new WorkCycle();
            newWorkCycle.setWorkCycleId(workcycleId);
            newWorkCycle.setPhotoId(photo.getPhotoId());
            workCycleMapper.updateByPrimaryKeySelective(newWorkCycle);
        }
        //删除源文件
        try {
            if (oldFilePath != null && oldFilePath.trim().length() > 0) {
                File file = new File(oldFilePath);
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {

        }

    }


    /**
     * Save report item photo.
     *
     * @param reportItemScoreId the report item score id
     * @param multipartFiles    the multipart files
     */
    @Override
    public void saveReportItemPhoto(Integer reportItemScoreId, MultipartFile[] multipartFiles) {
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
        reportItemScoreMapper.updateByPrimaryKeySelective(reportItemScore);
    }

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

    /**
     * Download file string.
     *
     * @param photoId the photo id
     * @return the string
     */
    @Override
    public String downloadFile(Integer photoId) {
        Photo photo = photoMapper.selectByPrimaryKey(photoId);
        if (photo != null) {
            return photo.getPhotoAddr();
        }
        throw new RuntimeException("file not exist!");
    }


    /**
     * Delete report item photo string.
     *
     * @param reportItemScoreId the report item score id
     * @param photoId           the photo id
     * @return the string
     */
    @Override
    public String deleteReportItemPhoto(Integer reportItemScoreId, Integer photoId) {
        Photo photo = photoMapper.selectByPrimaryKey(photoId);
        if (photo != null) {
            return photo.getPhotoAddr();
        }
        throw new RuntimeException("file not exist!");
    }
}
