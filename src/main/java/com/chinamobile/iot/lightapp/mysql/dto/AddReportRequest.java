package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;

public class AddReportRequest implements Serializable {

    private String reportName;

    private Integer cycleId;

    private Integer regionId;

    private Integer periodId;

    private static final long serialVersionUID = 1L;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }


}