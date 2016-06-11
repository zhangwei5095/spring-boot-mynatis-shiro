package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户喜好实体类
 */
@Entity
@Table(name = "USERPREFERENCES")
public class UserPreferences extends BaseEntity {
    private Long id;
    private Long userId;
    private Long lastRoleId;
    private Long lastLoginTime;
    private Long curLoginTime;
    private Long lang;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLastRoleId() {
        return lastRoleId;
    }

    public void setLastRoleId(Long lastRoleId) {
        this.lastRoleId = lastRoleId;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getCurLoginTime() {
        return curLoginTime;
    }

    public void setCurLoginTime(Long curLoginTime) {
        this.curLoginTime = curLoginTime;
    }

    public Long getLang() {
        return lang;
    }

    public void setLang(Long lang) {
        this.lang = lang;
    }
}
