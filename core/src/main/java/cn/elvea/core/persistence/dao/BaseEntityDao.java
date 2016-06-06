package cn.elvea.core.persistence.dao;

import cn.elvea.core.domain.IdEntity;
import org.springframework.jdbc.support.KeyHolder;

import java.io.Serializable;

@SuppressWarnings({"unchecked"})
public abstract class BaseEntityDao<T extends IdEntity, PK extends Serializable> extends BaseDao {
    public Long getKey(KeyHolder keyHolder, T t) {
        long key = keyHolder.getKey().longValue();
        t.setId(key);
        return key;
    }
}