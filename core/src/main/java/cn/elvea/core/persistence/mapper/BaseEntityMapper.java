package cn.elvea.core.persistence.mapper;

import cn.elvea.core.persistence.IdEntity;

import java.io.Serializable;

public interface BaseEntityMapper<T extends IdEntity, PK extends Serializable> extends BaseMapper {
}
