package com.chinamobile.iot.lightapp.mysql.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void saveUserPhoto(Integer userId, MultipartFile multipartFile);

    /**
     * Save workcycle photo.
     *
     * @param workcycleId   the workcycle id
     * @param multipartFile the multipart file
     */
    public void saveWorkcyclePhoto(Integer workcycleId, MultipartFile multipartFile);

    /**
     * Save report item photo.
     *
     * @param reportItemScoreId the report item score id
     * @param multipartFiles    the multipart files
     */
    public void saveReportItemPhoto(Integer reportItemScoreId, MultipartFile[] multipartFiles);

    /**
     * Download file string.
     *
     * @param photoId the photo id
     * @return the string
     */
    public String downloadFile(Integer photoId);

    /**
     * Delete report item photo string.
     *
     * @param reportItemScoreId the report item score id
     * @param photoId           the photo id
     * @return the string
     */
    public String deleteReportItemPhoto(Integer reportItemScoreId, Integer photoId);
}
