package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;
import java.util.List;

public class UpdateCheckItemDTO implements Serializable {
    private List<CheckItemDTO> checkItemList;

    public List<CheckItemDTO> getCheckItemList() {
        return checkItemList;
    }

    public void setCheckItemList(List<CheckItemDTO> checkItemList) {
        this.checkItemList = checkItemList;
    }
}