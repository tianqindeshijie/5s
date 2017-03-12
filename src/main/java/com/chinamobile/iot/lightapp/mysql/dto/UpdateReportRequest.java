package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;

public class UpdateReportRequest implements Serializable {
    private Integer reportId;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    private String reportName;
    private static final long serialVersionUID = 1L;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }


}