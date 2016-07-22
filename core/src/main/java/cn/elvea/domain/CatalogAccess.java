package cn.elvea.domain;

import cn.elvea.commons.domain.AbstractEntity;

import java.sql.Timestamp;

public class CatalogAccess extends AbstractEntity {
    private Long id;
    private String accessType;
    private Long accessRoleId;
    private Long accessEntityId;
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

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Long getAccessRoleId() {
        return accessRoleId;
    }

    public void setAccessRoleId(Long accessRoleId) {
        this.accessRoleId = accessRoleId;
    }

    public Long getAccessEntityId() {
        return accessEntityId;
    }

    public void setAccessEntityId(Long accessEntityId) {
        this.accessEntityId = accessEntityId;
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
