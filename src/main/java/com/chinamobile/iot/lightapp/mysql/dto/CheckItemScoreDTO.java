package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;

/**
 * The type Check item score dto.
 */
public class CheckItemScoreDTO implements Serializable {
    private Integer checkItemScoreId;

    private Integer checkItemId;

    private String remarkContent;

    private Integer score;

    private Integer reportItemScoreId;

    private Integer reportId;

    private String checkItemName;

    private String checkItemContent;
    /**
     * Gets check item name.
     *
     * @return the check item name
     */
    public String getCheckItemName() {
        return checkItemName;
    }

    /**
     * Sets check item name.
     *
     * @param checkItemName the check item name
     */
    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    /**
     * Gets check item content.
     *
     * @return the check item content
     */
    public String getCheckItemContent() {
        return checkItemContent;
    }

    /**
     * Sets check item content.
     *
     * @param checkItemContent the check item content
     */
    public void setCheckItemContent(String checkItemContent) {
        this.checkItemContent = checkItemContent;
    }


    private static final long serialVersionUID = 1L;

    /**
     * Gets check item score id.
     *
     * @return the check item score id
     */
    public Integer getCheckItemScoreId() {
        return checkItemScoreId;
    }

    /**
     * Sets check item score id.
     *
     * @param checkItemScoreId the check item score id
     */
    public void setCheckItemScoreId(Integer checkItemScoreId) {
        this.checkItemScoreId = checkItemScoreId;
    }

    /**
     * Gets check item id.
     *
     * @return the check item id
     */
    public Integer getCheckItemId() {
        return checkItemId;
    }

    /**
     * Sets check item id.
     *
     * @param checkItemId the check item id
     */
    public void setCheckItemId(Integer checkItemId) {
        this.checkItemId = checkItemId;
    }

    /**
     * Gets remark content.
     *
     * @return the remark content
     */
    public String getRemarkContent() {
        return remarkContent;
    }

    /**
     * Sets remark content.
     *
     * @param remarkContent the remark content
     */
    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent == null ? null : remarkContent.trim();
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

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
     * Gets report id.
     *
     * @return the report id
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * Sets report id.
     *
     * @param reportId the report id
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkItemScoreId=").append(checkItemScoreId);
        sb.append(", checkItemId=").append(checkItemId);
        sb.append(", remarkContent=").append(remarkContent);
        sb.append(", score=").append(score);
        sb.append(", reportItemScoreId=").append(reportItemScoreId);
        sb.append(", reportId=").append(reportId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}