package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 职级实体类
 */
@Entity
@Table(name = "POSITION")
public class Position extends BaseEntity {
    private String code;
    private String name;
    private String description;
    private String responsibilities;
    private String performance;
    private Integer parentid;
    private int orgunitid;
    private int active;
    private int synind;
    private Timestamp lstupdated;

    private String parentName;
    private String orgName;
    private boolean hasChild;
    private String lstupdatedFormat;
    private List<Map> skillList;

    public Position() {
    }

    public Position(Long id) {
        this.id = id;
    }

    public Position(int active, String code, Timestamp lstupdated, String name) {
        this.active = active;
        this.code = code;
        this.lstupdated = lstupdated;
        this.name = name;
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

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column
    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Column
    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Column
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Column
    public int getOrgunitid() {
        return orgunitid;
    }

    public void setOrgunitid(int orgunitid) {
        this.orgunitid = orgunitid;
    }

    @Column(nullable = false)
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getSynind() {
        return synind;
    }

    public void setSynind(int synind) {
        this.synind = synind;
    }

    @Column(nullable = false)
    public Timestamp getLstupdated() {
        return lstupdated;
    }

    public void setLstupdated(Timestamp lstupdated) {
        this.lstupdated = lstupdated;
    }


    @Transient
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Transient
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Transient
    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    @Transient
    public String getLstupdatedFormat() {
        return lstupdatedFormat;
    }

    public void setLstupdatedFormat(String lstupdatedFormat) {
        this.lstupdatedFormat = lstupdatedFormat;
    }

    @Transient
    public List<Map> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Map> skillList) {
        this.skillList = skillList;
    }
}
