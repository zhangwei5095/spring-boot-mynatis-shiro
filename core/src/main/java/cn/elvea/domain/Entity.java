package cn.elvea.domain;

import cn.elvea.commons.domain.BaseEntity;

@javax.persistence.Entity
public class Entity extends BaseEntity {
    // 实体类型
    public final static String TYPE_ROL = "ROL"; // 角色
    public final static String TYPE_USR = "USR"; // 用户
    public final static String TYPE_ORG = "ORG"; // 组织
    public final static String TYPE_DPT = "DPT"; // 部门
    public final static String TYPE_PST = "PST"; // 岗位

    // 实体来源
    public final static String SOURCE_SYS = "SYS"; // 系统
    public final static String SOURCE_IMP = "IMP"; // 导入
    public final static String SOURCE_SYNC = "SYNC"; // 由其他系统同步过来
    public final static String SOURCE_NORMAL = "NORMAL"; // 页面添加
    public final static String SOURCE_WEB = "WEB"; // 页面注册
    public final static String SOURCE_APP = "REG"; // 移动端注册

    // 唯一编号
    private Long uid;
    // 来源
    private Long source;
    // 实体类型
    private Long type;
    // 创建时间
    private Long createdAt;
    // 创建人
    private Long createdBy;
    // 编辑时间
    private Long updatedAt;
    // 编辑人
    private Long updatedBy;
    // 删除时间
    private Long deletedAt;
    // 删除人
    private Long deletedBy;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }
}
