package cn.elvea.domain;

import cn.elvea.commons.domain.AbstractEntity;

import java.sql.Timestamp;

/**
 * 实体关联
 */
public class EntityRelation extends AbstractEntity {
    // 实体关联类型
    public final static String TYPE_USR_CURRENT_DPT = "USR_CURRENT_DPT"; // 用户-部门
    public final static String TYPE_USR_CURRENT_PST = "USR_CURRENT_PST"; // 用户-岗位
    public final static String TYPE_ORG_PARENT_ORG = "ORG_PARENT_ORG"; // 组织-组织
    public final static String TYPE_PST_PARENT_PST = "PST_PARENT_PST"; // 岗位-岗位
    public final static String TYPE_DPT_PARENT_DPT = "DPT_PARENT_DPT"; // 部门-部门

    private Long id;
    private Long parentId;
    private Long childId;
    private Integer level;
    private Boolean parentInd;
    private String type;
    private Timestamp createAt;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getParentInd() {
        return parentInd;
    }

    public void setParentInd(Boolean parentInd) {
        this.parentInd = parentInd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
