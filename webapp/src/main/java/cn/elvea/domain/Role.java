package cn.elvea.domain;

import cn.elvea.core.domain.BaseEntity;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 角色实体类
 */
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity {
    public static final String CODE_PREFIX = "ROLE";
    public static final String CODE_SYSADM = "SYSADM";
    public static final String CODE_TADM = "TADM";
    public static final String CODE_LRN = "LRN";
    public static final String CODE_INSTR = "INSTR";

    public static final int TYPE_TRAINER = 1;
    public static final int TYPE_LEARNER = 2;
    public static final int TYPE_TEACHER = 3;
    public static final int TYPE_SUPER = 4;

    private String code;
    private int type;
    private String labelname;
    private String description;
    private int customind;
    private String url;
    private int active;
    private int creator;
    private Timestamp createdate;
    private int modifiedby;
    private Timestamp modifieddate;
    private List<Permission> permissionlst = Lists.newArrayList();
    private String permissionIdList;
    private String name;
    private int teacherInd;
    private int superInd;
    private int trainerInd;
    private int learnerInd;

    public Role() {
    }

    public Role(String code, int customind, int active) {
        super();
        this.code = code;
        this.customind = customind;
        this.active = active;
    }

    @Column(nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public int getCustomind() {
        return customind;
    }

    public void setCustomind(int customind) {
        this.customind = customind;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(nullable = false)
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public int getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(int modifiedby) {
        this.modifiedby = modifiedby;
    }

    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    //多对多定义
    @ManyToMany(fetch = FetchType.LAZY)
    //中间表定义,表名采用默认命名规则
    @JoinTable(name = "ROLEPERMISSIONS", joinColumns = {@JoinColumn(name = "roleid")}, inverseJoinColumns = {@JoinColumn(name = "permissionid")})
    //Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    //集合按id排序.
    @OrderBy("id")
    public List<Permission> getPermissionlst() {
        return permissionlst;
    }

    public void setPermissionlst(List<Permission> permissionlst) {
        this.permissionlst = permissionlst;
    }

    @Transient
    public String getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(String permissionIdList) {
        this.permissionIdList = permissionIdList;
    }

    @Transient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public int getTeacherInd() {
        return teacherInd;
    }

    public void setTeacherInd(int teacherInd) {
        this.teacherInd = teacherInd;
    }

    @Transient
    public int getSuperInd() {
        return superInd;
    }

    public void setSuperInd(int superInd) {
        this.superInd = superInd;
    }

    @Transient
    public int getTrainerInd() {
        return trainerInd;
    }

    public void setTrainerInd(int trainerInd) {
        this.trainerInd = trainerInd;
    }

    @Transient
    public int getLearnerInd() {
        return learnerInd;
    }

    public void setLearnerInd(int learnerInd) {
        this.learnerInd = learnerInd;
    }
}
