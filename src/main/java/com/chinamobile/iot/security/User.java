package com.chinamobile.iot.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

/**
 * Created by xuetao on 2017/1/9.
 */
public class User implements UserDetails, Serializable {

    private Integer userId;

    private String phone;

    private String nickName;

    private String password;


    /**
     * Instantiates a new User.
     *
     * @param phone       the phone
     * @param password    the password
     * @param userId      the user id
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
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是被否锁定或未被锁定.。无法进行身份验证的锁定用户。
     *
     * @return <code>true</code> 如果用户没有被锁定 <code>false</code> 其它
     */
    @Override
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
    public boolean isEnabled() {
        return true;
    }


}
