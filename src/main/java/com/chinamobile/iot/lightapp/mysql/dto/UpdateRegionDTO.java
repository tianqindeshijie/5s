package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Region;

/**
 * The type Update region dto.
 */
public class UpdateRegionDTO extends Region {
    private Integer operateType;

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
}