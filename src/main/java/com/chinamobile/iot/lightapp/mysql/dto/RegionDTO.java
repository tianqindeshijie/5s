package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Region;

import java.io.Serializable;

public class RegionDTO extends Region {
    private String workCycleName;

    public String getWorkCycleName() {
        return workCycleName;
    }

    public void setWorkCycleName(String workCycleName) {
        this.workCycleName = workCycleName;
    }
}