package com.chinamobile.iot.lightapp.mysql.dto;

/**
 * The type User workcycle dto.
 */
public class UserWorkcycleDTO {

    private Integer workCycleId;

    private Integer userId;

    private Integer isManager;

    private String workCycleName;

    private Integer photoId;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    /**
     * Gets work cycle id.
     *
     * @return the work cycle id
     */
    public Integer getWorkCycleId() {
        return workCycleId;
    }

    /**
     * Sets work cycle id.
     *
     * @param workCycleId the work cycle id
     */
    public void setWorkCycleId(Integer workCycleId) {
        this.workCycleId = workCycleId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets is manager.
     *
     * @return the is manager
     */
    public Integer getIsManager() {
        return isManager;
    }

    /**
     * Sets is manager.
     *
     * @param isManager the is manager
     */
    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
    }

    /**
     * Gets work cycle name.
     *
     * @return the work cycle name
     */
    public String getWorkCycleName() {
        return workCycleName;
    }

    /**
     * Sets work cycle name.
     *
     * @param workCycleName the work cycle name
     */
    public void setWorkCycleName(String workCycleName) {
        this.workCycleName = workCycleName;
    }
}