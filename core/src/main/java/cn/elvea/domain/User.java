package cn.elvea.domain;

import cn.elvea.commons.domain.BaseEntity;
import com.google.common.collect.Lists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

/**
 * 用户实体类
 */
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
    public static final String SOURCE_SYS = "SYS"; // 系统账号(不允许删除)
    public static final String SOURCE_IMP = "IMP"; // 导入的账号
    public static final String SOURCE_NORMAL = "NORMAL"; // 正常添加的账号
    public static final String SOURCE_WEB = "WEB"; // PC端注册账号
    public static final String SOURCE_APP = "APP"; // 移动端注册账号

    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_FREEZED = "FREEZED";
    public static final String STATUS_EXPIRED = "EXPIRED";
    public static final String STATUS_DELETED = "DELETED";
    public static final String STATUS_OK = "OK";

    @Column
    private String username;

    @Column
    private String email;
    private String mobile;
    private String password;
    private String salt;
    private String nickname;
    private String fullname;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;
    private String sourse;
    private Timestamp createdAt;
    private int createdBy;
    private Timestamp updatedAt;
    private int updatedBy;

    @Transient
    private List<Role> roles = Lists.newArrayList();

    public User() {
    }

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
