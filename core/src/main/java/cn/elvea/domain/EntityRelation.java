package cn.elvea.domain;

import cn.elvea.commons.domain.BaseEntity;

import java.sql.Timestamp;

/**
 * 实体关联
 */
@javax.persistence.Entity
public class EntityRelation extends BaseEntity {
    // 实体关联类型
    public final static String TYPE_USR_CURRENT_DPT = "USR_CURRENT_DPT"; // 用户-部门
    public final static String TYPE_USR_CURRENT_PST = "USR_CURRENT_PST"; // 用户-岗位
    public final static String TYPE_USR_CURRENT_ROL = "USR_CURRENT_ROL"; // 用户-角色
    public final static String TYPE_ORG_PARENT_ORG = "ORG_PARENT_ORG"; // 组织-组织
    public final static String TYPE_PST_PARENT_PST = "PST_PARENT_PST"; // 岗位-岗位
    public final static String TYPE_DPT_PARENT_DPT = "DPT_PARENT_DPT"; // 部门-部门

    private Long parentId;
    private Long childId;
    private boolean parentInd;
    private Integer level;
    private String type;
    private Timestamp createdAt;
    private Long createdBy;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public boolean isParentInd() {
        return parentInd;
    }

    public void setParentInd(boolean parentInd) {
        this.parentInd = parentInd;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
