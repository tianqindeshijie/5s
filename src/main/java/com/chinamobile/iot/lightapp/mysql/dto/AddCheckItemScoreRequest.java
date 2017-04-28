package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.CheckItemScore;

import java.util.List;

/**
 * Created by xuetao on 2017/4/25.
 */
public class AddCheckItemScoreRequest {

    private Integer reportItemId;

    private List<CheckItemScore> checkItemScoreList;

    /**
     * Gets check item score list.
     *
     * @return the check item score list
     */
    public List<CheckItemScore> getCheckItemScoreList() {
        return checkItemScoreList;
    }

    /**
     * Sets check item score list.
     *
     * @param checkItemScoreList the check item score list
     */
    public void setCheckItemScoreList(List<CheckItemScore> checkItemScoreList) {
        this.checkItemScoreList = checkItemScoreList;
    }
}
