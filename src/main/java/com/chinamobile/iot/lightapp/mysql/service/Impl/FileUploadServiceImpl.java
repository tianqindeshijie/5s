package com.chinamobile.iot.lightapp.mysql.service.Impl;

import com.chinamobile.iot.lightapp.mysql.dao.PhotoMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserMapper;
import com.chinamobile.iot.lightapp.mysql.model.Photo;
import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by xuetao on 2017/5/23.
 */
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private UserMapper userMapper;

    @Value("${5s.file.path:./photo}")
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
     * Save file.
     *
     * @param userId        the user id
     * @param multipartFile the multipart file
     */
    @Override
    public void saveFile(Integer userId, MultipartFile multipartFile) {
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
            photoMapper.insert(photo);
            User newUser = new User();
            newUser.setPhotoId(photo.getPhotoId());
            userMapper.insert(newUser);
        }
        //删除源文件
        try{
            if(oldFilePath != null && oldFilePath.trim().length() > 0) {
                File file = new File(oldFilePath);
                if(file.isFile() && file.exists()) {
                    file.deleteOnExit();
                }
            }
        } catch (Exception e) {

        }

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
}
