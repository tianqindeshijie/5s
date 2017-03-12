package com.chinamobile.iot.lightapp.mysql.dto;

import java.util.List;

/**
 * Created by SEELE on 2017/3/1.
 */
public class ApplyResult {
    List<ApplyResultDTO> resultList;

    public List<ApplyResultDTO> getResultList() {
        return resultList;
    }

    public void setResultList(List<ApplyResultDTO> resultList) {
        this.resultList = resultList;
    }
}
