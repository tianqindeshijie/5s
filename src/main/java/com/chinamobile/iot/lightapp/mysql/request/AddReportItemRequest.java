package com.chinamobile.iot.lightapp.mysql.request;

import com.chinamobile.iot.lightapp.mysql.model.ReportItem;

import java.util.List;

/**
 * Created by xuetao on 2017/4/11.
 */
public class AddReportItemRequest {
    private List<ReportItem> reportItemList;

    public List<ReportItem> getReportItemList() {
        return reportItemList;
    }

    public void setReportItemList(List<ReportItem> reportItemList) {
        this.reportItemList = reportItemList;
    }
}
