package com.chinamobile.iot.lightapp.mysql.dto;

/**
 * Created by SEELE on 2017/3/1.
 */
public class ApplyResultDTO {
    private Integer result;
    private String applyUserPhone;
    private Integer cycleId;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getApplyUserPhone() {
        return applyUserPhone;
    }

    public void setApplyUserPhone(String applyUserPhone) {
        this.applyUserPhone = applyUserPhone;
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }
}
