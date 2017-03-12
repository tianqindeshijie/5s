package com.chinamobile.iot.lightapp.mysql.request;

/**
 * Created by SEELE on 2017/2/28.
 */
public class UpdateApplyRequest {
    private Integer applyId;
    private Integer result;

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
