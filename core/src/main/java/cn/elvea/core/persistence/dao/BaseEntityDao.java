package cn.elvea.core.persistence.dao;

import cn.elvea.core.domain.IdEntity;
import org.springframework.jdbc.support.KeyHolder;

import java.io.Serializable;

@SuppressWarnings({"unchecked"})
public abstract class BaseEntityDao<T extends IdEntity, PK extends Serializable> extends BaseDao {
    public PK getKey(KeyHolder keyHolder, T t) {
        t.setId(keyHolder.getKey().longValue());
        return (PK) t.getId();
    }
}