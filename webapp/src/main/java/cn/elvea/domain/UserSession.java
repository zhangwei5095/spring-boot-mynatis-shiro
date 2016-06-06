package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户会话实体类
 */
@Entity
@Table(name = "userSession")
public class UserSession extends BaseEntity {
    private String sessionId;
    private String username;
    private String host;
    private Date lastAccessDatetime;
    private Date startDatetime;
    private Date endDatetime;

    @Column(nullable = false)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Column(nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Column(nullable = false)
    public Date getLastAccessDatetime() {
        return lastAccessDatetime;
    }

    public void setLastAccessDatetime(Date lastAccessDatetime) {
        this.lastAccessDatetime = lastAccessDatetime;
    }

    @Column(nullable = false)
    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    @Column(nullable = false)
    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }
}
