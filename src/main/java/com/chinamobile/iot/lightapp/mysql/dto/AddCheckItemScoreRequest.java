package com.chinamobile.iot.lightapp.mysql.dto;

import java.util.List;

/**
 * Created by xuetao on 2017/4/25.
 */
public class AddCheckItemScoreRequest {

    private Integer reportItemId;

    private Integer reportId;

    private List<CheckItemScoreVO> checkItemScoreList;

    /**
     * Gets check item score list.
     *
     * @return the check item score list
     */
    public List<CheckItemScoreVO> getCheckItemScoreList() {
        return checkItemScoreList;
    }

    public Integer getReportItemId() {
        return reportItemId;
    }

    public void setReportItemId(Integer reportItemId) {
        this.reportItemId = reportItemId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public void setCheckItemScoreList(List<CheckItemScoreVO> checkItemScoreList) {
        this.checkItemScoreList = checkItemScoreList;
    }
}
