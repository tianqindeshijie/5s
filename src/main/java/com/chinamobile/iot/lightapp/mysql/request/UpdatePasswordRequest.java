package com.chinamobile.iot.lightapp.mysql.request;

/**
 * Created by SEELE on 2017/2/15.
 */
public class UpdatePasswordRequest {
    private String oldPassword;  //老密码
    private String newPassword;     //新密码

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
