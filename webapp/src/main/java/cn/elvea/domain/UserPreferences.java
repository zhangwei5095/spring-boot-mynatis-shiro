package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 用户喜好实体类
 */
@Entity
@Table(name = "USERPREFERENCES")
public class UserPreferences extends BaseEntity {
    private int userid;
    private int lastroleid;
    private Timestamp lastlogintime;
    private Timestamp curlogintime;
    private String skin;
    private String language;
    private int homestyletype;
    private Timestamp lstupdated;

    public UserPreferences(int userid) {
        super();
        this.userid = userid;
    }

    public UserPreferences() {
        super();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getLastroleid() {
        return lastroleid;
    }

    public void setLastroleid(int lastroleid) {
        this.lastroleid = lastroleid;
    }

    public Timestamp getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Timestamp lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Timestamp getCurlogintime() {
        return curlogintime;
    }

    public void setCurlogintime(Timestamp curlogintime) {
        this.curlogintime = curlogintime;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getHomestyletype() {
        return homestyletype;
    }

    public void setHomestyletype(int homestyletype) {
        this.homestyletype = homestyletype;
    }

    public Timestamp getLstupdated() {
        return lstupdated;
    }

    public void setLstupdated(Timestamp lstupdated) {
        this.lstupdated = lstupdated;
    }

}
