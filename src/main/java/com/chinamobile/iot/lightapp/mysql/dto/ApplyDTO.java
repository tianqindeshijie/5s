package com.chinamobile.iot.lightapp.mysql.dto;

/**
 * Created by SEELE on 2017/2/28.
 */
public class ApplyDTO {

    /**
     * The Apply user phone.
     */
    private String applyUserPhone;//申请人手机号
    /**
     * The Inviter.
     */
    private Integer inviter;//邀请人ID
    /**
     * The Cycle id.
     */
    private Integer cycleId;//工作圈ID
    /**
     * The Apply type.
     */
    private Integer applyType;//申请类型：0用户申请，1管理员邀请

    public String getApplyUserPhone() {
        return applyUserPhone;
    }

    public void setApplyUserPhone(String applyUserPhone) {
        this.applyUserPhone = applyUserPhone;
    }

    public Integer getInviter() {
        return inviter;
    }

    public void setInviter(Integer inviter) {
        this.inviter = inviter;
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }
}
