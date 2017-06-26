package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.WorkCycle;

import java.io.Serializable;
import java.util.List;

public class UpdateWorkCycleAndRegion extends WorkCycle implements Serializable {

    private List<UpdateRegionDTO> regionList;

    public List<UpdateRegionDTO> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<UpdateRegionDTO> regionList) {
        this.regionList = regionList;
    }
}