package cn.elvea.domain;

import cn.elvea.commons.domain.AbstractEntity;

public class Entity extends AbstractEntity {
    // 实体类型
    public final static String TYPE_USR = "USR"; // 用户
    public final static String TYPE_ORG = "ORG"; // 组织
    public final static String TYPE_DPT = "DPT"; // 部门
    public final static String TYPE_PST = "PST"; // 岗位

    private Long id;
    private String code;
    private String type;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
