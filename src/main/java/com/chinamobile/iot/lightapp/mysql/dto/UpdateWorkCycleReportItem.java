package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;
import java.util.List;

public class UpdateWorkCycleReportItem implements Serializable {
    private Integer workCycleId;
    private List<ReportItemDTO> reportItemList;

    public Integer getWorkCycleId() {
        return workCycleId;
    }

    public void setWorkCycleId(Integer workCycleId) {
        this.workCycleId = workCycleId;
    }

    public List<ReportItemDTO> getReportItemList() {
        return reportItemList;
    }

    public void setReportItemList(List<ReportItemDTO> reportItemList) {
        this.reportItemList = reportItemList;
    }
}