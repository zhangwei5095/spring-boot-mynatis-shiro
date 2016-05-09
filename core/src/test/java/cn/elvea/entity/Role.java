package cn.elvea.entity;

import cn.elvea.core.persistence.jpa.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
}
