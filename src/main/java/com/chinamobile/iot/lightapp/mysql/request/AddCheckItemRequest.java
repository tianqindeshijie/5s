package com.chinamobile.iot.lightapp.mysql.request;

import com.chinamobile.iot.lightapp.mysql.model.CheckItem;

import java.util.List;

/**
 * Created by xuetao on 2017/4/11.
 */
public class AddCheckItemRequest {
    private List<CheckItem> checkItemList;

    /**
     * Gets check item list.
     *
     * @return the check item list
     */
    public List<CheckItem> getCheckItemList() {
        return checkItemList;
    }

    /**
     * Sets check item list.
     *
     * @param checkItemList the check item list
     */
    public void setCheckItemList(List<CheckItem> checkItemList) {
        this.checkItemList = checkItemList;
    }
}
