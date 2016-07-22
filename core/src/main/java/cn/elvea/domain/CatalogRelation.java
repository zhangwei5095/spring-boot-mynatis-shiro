package cn.elvea.domain;

import cn.elvea.commons.domain.AbstractEntity;

import java.sql.Timestamp;

public class CatalogRelation extends AbstractEntity {
    private Long id;
    private Long parentId;
    private Long childId;
    private boolean parentInd;
    private int level;
    private Timestamp createdAt;
    private Long createdBy;

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

    public boolean isParentInd() {
        return parentInd;
    }

    public void setParentInd(boolean parentInd) {
        this.parentInd = parentInd;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
