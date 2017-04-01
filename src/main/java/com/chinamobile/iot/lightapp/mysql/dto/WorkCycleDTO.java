package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;

/**
 * Created by xuetao on 2017/3/31.
 */
public class WorkCycleDTO extends WorkCycle{
    private Integer isManager;

    public Integer getIsManager() {
        return isManager;
    }

    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
    }
}
