package cn.elvea.domain;

import cn.elvea.commons.domain.AbstractEntity;

import java.sql.Timestamp;

public class CatalogAccess extends AbstractEntity {
    // 访问类型
    public final static String TYPE_DENY = "DENY"; // 拒绝
    public final static String TYPE_GRANT = "GRANT"; // 授权

    private Long id;
    private Long catalogId;
    private Long roleId;
    private Long entityId;
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

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
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
