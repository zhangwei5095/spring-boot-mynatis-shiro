package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;
import com.google.common.collect.Lists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

/**
 * 组织架构实体类
 */
@Entity
@Table(name = "ORGUNIT")
public class Organization extends BaseEntity {
    private String code;
    private String name;
    private String fullname;
    private String description;
    private int synind;
    private int active;
    private int wxorgid;
    private Timestamp lstupdated;
    private List<User> supervisorlst = Lists.newArrayList();
    private String supervisoridlst;
    private String supervisornamelst;
    private List<User> headlst = Lists.newArrayList();
    private String headidlst;
    private String headnamelst;

    public Organization() {
    }

    public Organization(Long id) {
        this.id = id;
    }

    public Organization(String code, String name, String fullname, String description,
                        int synind, int active, Timestamp lstupdated) {
        this.code = code;
        this.name = name;
        this.fullname = fullname;
        this.description = description;
        this.synind = synind;
        this.active = active;
        this.lstupdated = lstupdated;
    }

    @Column(nullable = false, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;//DESCRIPTION description
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public int getSynind() {
        return synind;
    }

    public void setSynind(int synind) {
        this.synind = synind;
    }

    @Column(nullable = false)
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Column(nullable = false)
    public Timestamp getLstupdated() {
        return lstupdated;
    }

    public void setLstupdated(Timestamp lstupdated) {
        this.lstupdated = lstupdated;
    }

    @Transient
    public List<User> getSupervisorlst() {
        return supervisorlst;
    }

    public void setSupervisorlst(List<User> supervisorlst) {
        this.supervisorlst = supervisorlst;
    }

    @Transient
    public String getSupervisoridlst() {
        return this.supervisoridlst;
    }

    public void setSupervisoridlst(String supervisoridlst) {
        this.supervisoridlst = supervisoridlst;
    }

    @Transient
    public String getSupervisornamelst() {
        return this.supervisornamelst;
    }

    public void setSupervisornamelst(String supervisornamelst) {
        this.supervisornamelst = supervisornamelst;
    }

    @Transient
    public List<User> getHeadlst() {
        return headlst;
    }

    public void setHeadlst(List<User> headlst) {
        this.headlst = headlst;
    }

    @Transient
    public String getHeadidlst() {
        return headidlst;
    }

    public void setHeadidlst(String headidlst) {
        this.headidlst = headidlst;
    }

    @Transient
    public String getHeadnamelst() {
        return headnamelst;
    }

    public void setHeadnamelst(String headnamelst) {
        this.headnamelst = headnamelst;
    }

    public int getWxorgid() {
        return wxorgid;
    }

    public void setWxorgid(int wxorgid) {
        this.wxorgid = wxorgid;
    }
}
