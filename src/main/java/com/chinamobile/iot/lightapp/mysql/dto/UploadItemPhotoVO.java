package com.chinamobile.iot.lightapp.mysql.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xuetao on 2017/5/24.
 */
public class UploadItemPhotoVO {
    private Integer reportItemScoreId;
    private MultipartFile[] files;

    /**
     * Gets report item score id.
     *
     * @return the report item score id
     */
    public Integer getReportItemScoreId() {
        return reportItemScoreId;
    }

    /**
     * Sets report item score id.
     *
     * @param reportItemScoreId the report item score id
     */
    public void setReportItemScoreId(Integer reportItemScoreId) {
        this.reportItemScoreId = reportItemScoreId;
    }

    /**
     * Get files multipart file [ ].
     *
     * @return the multipart file [ ]
     */
    public MultipartFile[] getFiles() {
        return files;
    }

    /**
     * Sets files.
     *
     * @param files the files
     */
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
