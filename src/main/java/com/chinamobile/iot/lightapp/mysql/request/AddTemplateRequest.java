package com.chinamobile.iot.lightapp.mysql.request;

public class AddTemplateRequest {

    private String tplName;

    private String tplContent;

    private Integer tplType;

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
    }

    public String getTplContent() {
        return tplContent;
    }

    public void setTplContent(String tplContent) {
        this.tplContent = tplContent;
    }

    public Integer getTplType() {
        return tplType;
    }

    public void setTplType(Integer tplType) {
        this.tplType = tplType;
    }

}
