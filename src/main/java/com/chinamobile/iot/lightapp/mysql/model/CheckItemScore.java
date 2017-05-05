package com.chinamobile.iot.lightapp.mysql.model;

import java.io.Serializable;

public class CheckItemScore implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item_score.check_item_score_id
     *
     * @mbg.generated
     */
    private Integer checkItemScoreId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item_score.check_item_id
     *
     * @mbg.generated
     */
    private Integer checkItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item_score.remark_content
     *
     * @mbg.generated
     */
    private String remarkContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item_score.score
     *
     * @mbg.generated
     */
    private Integer score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item_score.report_item_score_id
     *
     * @mbg.generated
     */
    private Integer reportItemScoreId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item_score.report_id
     *
     * @mbg.generated
     */
    private Integer reportId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item_score.check_item_score_id
     *
     * @return the value of check_item_score.check_item_score_id
     *
     * @mbg.generated
     */
    public Integer getCheckItemScoreId() {
        return checkItemScoreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item_score.check_item_score_id
     *
     * @param checkItemScoreId the value for check_item_score.check_item_score_id
     *
     * @mbg.generated
     */
    public void setCheckItemScoreId(Integer checkItemScoreId) {
        this.checkItemScoreId = checkItemScoreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item_score.check_item_id
     *
     * @return the value of check_item_score.check_item_id
     *
     * @mbg.generated
     */
    public Integer getCheckItemId() {
        return checkItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item_score.check_item_id
     *
     * @param checkItemId the value for check_item_score.check_item_id
     *
     * @mbg.generated
     */
    public void setCheckItemId(Integer checkItemId) {
        this.checkItemId = checkItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item_score.remark_content
     *
     * @return the value of check_item_score.remark_content
     *
     * @mbg.generated
     */
    public String getRemarkContent() {
        return remarkContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item_score.remark_content
     *
     * @param remarkContent the value for check_item_score.remark_content
     *
     * @mbg.generated
     */
    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent == null ? null : remarkContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item_score.score
     *
     * @return the value of check_item_score.score
     *
     * @mbg.generated
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item_score.score
     *
     * @param score the value for check_item_score.score
     *
     * @mbg.generated
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item_score.report_item_score_id
     *
     * @return the value of check_item_score.report_item_score_id
     *
     * @mbg.generated
     */
    public Integer getReportItemScoreId() {
        return reportItemScoreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item_score.report_item_score_id
     *
     * @param reportItemScoreId the value for check_item_score.report_item_score_id
     *
     * @mbg.generated
     */
    public void setReportItemScoreId(Integer reportItemScoreId) {
        this.reportItemScoreId = reportItemScoreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item_score.report_id
     *
     * @return the value of check_item_score.report_id
     *
     * @mbg.generated
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item_score.report_id
     *
     * @param reportId the value for check_item_score.report_id
     *
     * @mbg.generated
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item_score
     *
     * @mbg.generated
     */
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