package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;

import java.util.List;

/**
 * Created by SEELE on 2017/2/16.
 */
public class AddWorkCycleRequest {
    private String workCycleName;
    private List<Region> regionList;

    public String getWorkCycleName() {
        return workCycleName;
    }

    public void setWorkCycleName(String workCycleName) {
        this.workCycleName = workCycleName;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }
}
