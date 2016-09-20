package cn.elvea.domain;

import com.google.common.collect.Lists;

import java.sql.Timestamp;
import java.util.List;

/**
 * 用户实体类
 */
@javax.persistence.Entity
public class User extends Entity {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_FREEZED = "FREEZED";
    public static final String STATUS_EXPIRED = "EXPIRED";
    public static final String STATUS_DELETED = "DELETED";
    public static final String STATUS_OK = "OK";

    private String username;
    private String email;
    private String mobile;
    private String password;
    private String salt;
    private String nickname;
    private String fullname;
    private String description;
    private String status;
    private String lastLoginStatus;
    private Timestamp lastLoginDatetime;

    private List<Role> roles = Lists.newArrayList();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastLoginStatus() {
        return lastLoginStatus;
    }

    public void setLastLoginStatus(String lastLoginStatus) {
        this.lastLoginStatus = lastLoginStatus;
    }

    public Timestamp getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
