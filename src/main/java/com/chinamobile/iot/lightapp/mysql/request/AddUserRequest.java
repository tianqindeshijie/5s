package com.chinamobile.iot.lightapp.mysql.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Add user request.
 */
public class AddUserRequest implements Serializable {
    @NotEmpty(message="用户名不能为空")
    private String userName;

    private String nickName;
    @NotEmpty(message="电话号码不能为空")
    private String phone;
    @NotEmpty(message="邮箱不能为空")
    @Email(message = "请输入正确的邮箱")
    private String email;
    @NotEmpty(message="密码不能为空")
    private String password;

    private static final long serialVersionUID = 1L;

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}