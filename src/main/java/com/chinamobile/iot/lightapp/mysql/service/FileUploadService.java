package com.chinamobile.iot.lightapp.mysql.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * The interface File upload service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface FileUploadService {


    /**
     * Save file.
     *
     * @param userId        the user id
     * @param multipartFile the multipart file
     */
    public void saveFile(Integer userId, MultipartFile multipartFile);

}
