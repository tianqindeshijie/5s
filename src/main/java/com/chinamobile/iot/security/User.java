package com.chinamobile.iot.security;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by xuetao on 2017/1/9.
 */
public class User implements UserDetails, Serializable {

    private Integer userId;

    private String nickName;

    private String phone;

    private String email;

    private String imgAddr;

    private Integer gender;

    private String company;

    private String post;

    private String department;

    private Date joinTime;

    private String signature;
    @JSONField(serialize = false)
    private String password;

    /**
     * Instantiates a new User.
     *
     */
    public User() {
    }
    /**
     * Instantiates a new User.
     *
     * @param phone    the phone
     * @param password the password
     * @param userId   the user id
     */
    public User(String phone, String password, Integer userId) {
        this.phone = phone;
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
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
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    @JSONField(serialize = false)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        return grantedAuthorities;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    @JSONField(serialize = false)
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>
     * .
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return nickName;
    }


    /**
     * 指示用户帐户是否已过期，无法验证过期帐户。
     *
     * @return <code>true</code> 如果用户的帐户是有效的(即没有过期),
     * <code>false</code> 如果账户无效(即过期)
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是被否锁定或未被锁定.。无法进行身份验证的锁定用户。
     *
     * @return <code>true</code> 如果用户没有被锁定 <code>false</code> 其它
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示用户凭据（密码）是否已过期.。过期凭证防止身份验证。
     *
     * @return <code>true</code> 如果用户凭证有效(即未过期),
     * <code>false</code>无效(过期)(ie expired)
     */
    @Override
    @JSONField(serialize = false)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return true;
    }

    /**
     * Gets signature.
     *
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets signature.
     *
     * @param signature the signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
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
     * Gets img addr.
     *
     * @return the img addr
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * Sets img addr.
     *
     * @param imgAddr the img addr
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * Gets company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets company.
     *
     * @param company the company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets post.
     *
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * Sets post.
     *
     * @param post the post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets join time.
     *
     * @return the join time
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     * Sets join time.
     *
     * @param joinTime the join time
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
