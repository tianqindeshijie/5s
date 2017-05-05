package com.chinamobile.iot.lightapp.mysql.model;

import java.io.Serializable;

public class CheckItem implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item.check_item_id
     *
     * @mbg.generated
     */
    private Integer checkItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item.check_item_name
     *
     * @mbg.generated
     */
    private String checkItemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item.item_id
     *
     * @mbg.generated
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item.check_item_content
     *
     * @mbg.generated
     */
    private String checkItemContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_item.priority
     *
     * @mbg.generated
     */
    private Integer priority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_item
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item.check_item_id
     *
     * @return the value of check_item.check_item_id
     *
     * @mbg.generated
     */
    public Integer getCheckItemId() {
        return checkItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item.check_item_id
     *
     * @param checkItemId the value for check_item.check_item_id
     *
     * @mbg.generated
     */
    public void setCheckItemId(Integer checkItemId) {
        this.checkItemId = checkItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item.check_item_name
     *
     * @return the value of check_item.check_item_name
     *
     * @mbg.generated
     */
    public String getCheckItemName() {
        return checkItemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item.check_item_name
     *
     * @param checkItemName the value for check_item.check_item_name
     *
     * @mbg.generated
     */
    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName == null ? null : checkItemName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item.item_id
     *
     * @return the value of check_item.item_id
     *
     * @mbg.generated
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item.item_id
     *
     * @param itemId the value for check_item.item_id
     *
     * @mbg.generated
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item.check_item_content
     *
     * @return the value of check_item.check_item_content
     *
     * @mbg.generated
     */
    public String getCheckItemContent() {
        return checkItemContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item.check_item_content
     *
     * @param checkItemContent the value for check_item.check_item_content
     *
     * @mbg.generated
     */
    public void setCheckItemContent(String checkItemContent) {
        this.checkItemContent = checkItemContent == null ? null : checkItemContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_item.priority
     *
     * @return the value of check_item.priority
     *
     * @mbg.generated
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_item.priority
     *
     * @param priority the value for check_item.priority
     *
     * @mbg.generated
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_item
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkItemId=").append(checkItemId);
        sb.append(", checkItemName=").append(checkItemName);
        sb.append(", itemId=").append(itemId);
        sb.append(", checkItemContent=").append(checkItemContent);
        sb.append(", priority=").append(priority);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}