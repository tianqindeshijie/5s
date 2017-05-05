package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;

public class ReportItemScoreVO implements Serializable {
    private Integer reportItemScoreId;

    private String remarkContent;

    private Integer reportItemId;

    private Integer score;

    private Integer reportId;

    private Integer sScore;

    private String itemName;

    private String itemContent;

    private static final long serialVersionUID = 1L;

    public Integer getReportItemScoreId() {
        return reportItemScoreId;
    }

    public void setReportItemScoreId(Integer reportItemScoreId) {
        this.reportItemScoreId = reportItemScoreId;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent == null ? null : remarkContent.trim();
    }

    public Integer getReportItemId() {
        return reportItemId;
    }

    public void setReportItemId(Integer reportItemId) {
        this.reportItemId = reportItemId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

}