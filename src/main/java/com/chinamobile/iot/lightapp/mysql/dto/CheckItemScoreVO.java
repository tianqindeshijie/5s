package com.chinamobile.iot.lightapp.mysql.dto;

import java.io.Serializable;

/**
 * Created by xuetao on 2017/5/3.
 */
public class CheckItemScoreVO implements Serializable {
    private Integer checkItemId;

    private String remarkContent;

    private Integer score;


    private static final long serialVersionUID = 1L;

    public Integer getCheckItemId() {
        return checkItemId;
    }

    public void setCheckItemId(Integer checkItemId) {
        this.checkItemId = checkItemId;
    }

    /**
     * Gets remark content.
     *
     * @return the remark content
     */
    public String getRemarkContent() {
        return remarkContent;
    }

    /**
     * Sets remark content.
     *
     * @param remarkContent the remark content
     */
    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent == null ? null : remarkContent.trim();
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

}

