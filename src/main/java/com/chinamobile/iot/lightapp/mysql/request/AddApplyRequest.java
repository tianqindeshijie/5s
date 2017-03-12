package com.chinamobile.iot.lightapp.mysql.request;

import com.chinamobile.iot.lightapp.mysql.dto.ApplyDTO;

import java.util.List;

/**
 * Cy SEELE on 2017/2/28.
 */
public class AddApplyRequest {
   private List<ApplyDTO> applyList;

    public List<ApplyDTO> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<ApplyDTO> applyList) {
        this.applyList = applyList;
    }
}
