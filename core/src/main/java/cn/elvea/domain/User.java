package cn.elvea.domain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 用户实体类
 */
public class User extends Entity {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_FREEZED = "FREEZED";
    public static final String STATUS_EXPIRED = "EXPIRED";
    public static final String STATUS_DELETED = "DELETED";
    public static final String STATUS_OK = "OK";

    private Long username;
    private Long email;
    private Long mobile;
    private Long password;
    private Long salt;
    private Long nickname;
    private Long fullname;
    private Long description;
    private Long status;
    private Long source;
    private Long lastLoginStatus;
    private Long lastLoginDatetime;

    private List<Role> roles = Lists.newArrayList();

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public Long getEmail() {
        return email;
    }

    public void setEmail(Long email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Long getSalt() {
        return salt;
    }

    public void setSalt(Long salt) {
        this.salt = salt;
    }

    public Long getNickname() {
        return nickname;
    }

    public void setNickname(Long nickname) {
        this.nickname = nickname;
    }

    public Long getFullname() {
        return fullname;
    }

    public void setFullname(Long fullname) {
        this.fullname = fullname;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public Long getSource() {
        return source;
    }

    @Override
    public void setSource(Long source) {
        this.source = source;
    }

    public Long getLastLoginStatus() {
        return lastLoginStatus;
    }

    public void setLastLoginStatus(Long lastLoginStatus) {
        this.lastLoginStatus = lastLoginStatus;
    }

    public Long getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Long lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
