package com.chinamobile.iot.lightapp.mysql.request;

/**
 * Created by SEELE on 2017/2/28.
 */
public class UpdateApplyRequest {
    private Integer applyId;
    private Integer result;//0代表拒绝申请，1代表同意申请。

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
