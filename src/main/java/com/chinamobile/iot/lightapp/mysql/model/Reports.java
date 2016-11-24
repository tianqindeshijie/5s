package com.chinamobile.iot.lightapp.mysql.model;

import java.io.Serializable;

public class Reports implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reports.report_id
     *
     * @mbg.generated
     */
    private Integer reportId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reports.report_name
     *
     * @mbg.generated
     */
    private String reportName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reports.cycle_id
     *
     * @mbg.generated
     */
    private Integer cycleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reports.region_id
     *
     * @mbg.generated
     */
    private Integer regionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reports.period_id
     *
     * @mbg.generated
     */
    private Integer periodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reports.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reports
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reports.report_id
     *
     * @return the value of reports.report_id
     *
     * @mbg.generated
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reports.report_id
     *
     * @param reportId the value for reports.report_id
     *
     * @mbg.generated
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reports.report_name
     *
     * @return the value of reports.report_name
     *
     * @mbg.generated
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reports.report_name
     *
     * @param reportName the value for reports.report_name
     *
     * @mbg.generated
     */
    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reports.cycle_id
     *
     * @return the value of reports.cycle_id
     *
     * @mbg.generated
     */
    public Integer getCycleId() {
        return cycleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reports.cycle_id
     *
     * @param cycleId the value for reports.cycle_id
     *
     * @mbg.generated
     */
    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reports.region_id
     *
     * @return the value of reports.region_id
     *
     * @mbg.generated
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reports.region_id
     *
     * @param regionId the value for reports.region_id
     *
     * @mbg.generated
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reports.period_id
     *
     * @return the value of reports.period_id
     *
     * @mbg.generated
     */
    public Integer getPeriodId() {
        return periodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reports.period_id
     *
     * @param periodId the value for reports.period_id
     *
     * @mbg.generated
     */
    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reports.user_id
     *
     * @return the value of reports.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reports.user_id
     *
     * @param userId the value for reports.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reports
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportId=").append(reportId);
        sb.append(", reportName=").append(reportName);
        sb.append(", cycleId=").append(cycleId);
        sb.append(", regionId=").append(regionId);
        sb.append(", periodId=").append(periodId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}