package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Period;

import java.io.Serializable;
import java.util.Date;

public class PeriodDTO extends Period {
    private String workCycleName;

    public String getWorkCycleName() {
        return workCycleName;
    }

    public void setWorkCycleName(String workCycleName) {
        this.workCycleName = workCycleName;
    }
}