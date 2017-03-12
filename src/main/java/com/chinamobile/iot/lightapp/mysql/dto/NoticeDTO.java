package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Notice;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Notice dto.
 */
public class NoticeDTO extends Notice {
    private String workCycleName;

    public String getWorkCycleName() {
        return workCycleName;
    }

    public void setWorkCycleName(String workCycleName) {
        this.workCycleName = workCycleName;
    }
}