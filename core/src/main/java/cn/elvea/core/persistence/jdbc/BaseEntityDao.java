package cn.elvea.core.persistence.jdbc;

import cn.elvea.core.persistence.IdEntity;
import org.springframework.jdbc.support.KeyHolder;

import java.io.Serializable;

public abstract class BaseEntityDao<T extends IdEntity, PK extends Serializable> extends BaseDao {
    public Long getKey(KeyHolder keyHolder, T t) {
        t.setId(keyHolder.getKey().longValue());
        return t.getId();
    }
}