package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;

import java.io.Serializable;
import java.util.List;

public class WorkCycleAndRegion extends WorkCycle implements Serializable {

    private List<Region> regionList;

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }
}