package cn.elvea.commons.persistence.dao;

import cn.elvea.commons.domain.IdEntity;
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