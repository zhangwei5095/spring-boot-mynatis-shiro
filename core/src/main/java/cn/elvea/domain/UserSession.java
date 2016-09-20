package cn.elvea.domain;

import cn.elvea.commons.domain.AbstractEntity;

import java.util.Date;

/**
 * 用户会话实体类
 */
@javax.persistence.Entity
public class UserSession extends AbstractEntity {
    private Long id;
    private String sessionId;
    private String username;
    private String host;
    private String device;
    private Date lastAccessDatetime;
    private Date startDatetime;
    private Date endDatetime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Date getLastAccessDatetime() {
        return lastAccessDatetime;
    }

    public void setLastAccessDatetime(Date lastAccessDatetime) {
        this.lastAccessDatetime = lastAccessDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }
}
