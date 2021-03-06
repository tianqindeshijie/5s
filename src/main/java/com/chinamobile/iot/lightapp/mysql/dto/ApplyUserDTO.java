package com.chinamobile.iot.lightapp.mysql.dto;

import com.chinamobile.iot.lightapp.mysql.model.Apply;

/**
 * Created by sxt on 2017/2/28.
 */
public class ApplyUserDTO extends Apply {

    private String nickName;

    private String phone;

    private Integer userPhotoId;
    private String workCycleName;


    public Integer getUserPhotoId() {
        return userPhotoId;
    }

    public void setUserPhotoId(Integer userPhotoId) {
        this.userPhotoId = userPhotoId;
    }

    public String getWorkCycleName() {
        return workCycleName;
    }

    public void setWorkCycleName(String workCycleName) {
        this.workCycleName = workCycleName;
    }

    /**
     * Gets nick name.
     *
     * @return the nick name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets nick name.
     *
     * @param nickName the nick name
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
