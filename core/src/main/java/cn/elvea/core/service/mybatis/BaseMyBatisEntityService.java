package cn.elvea.core.service.mybatis;

import cn.elvea.core.domain.IdEntity;
import cn.elvea.core.persistence.mybatis.mapper.BaseEntityMapper;
import cn.elvea.core.persistence.mybatis.mapper.BaseMapper;
import cn.elvea.core.service.BaseEntityService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public abstract class BaseMyBatisEntityService<T extends IdEntity, PK extends Serializable> extends BaseMybatisService implements BaseEntityService<T, PK> {
    protected abstract BaseEntityMapper<T, PK> getEntityMapper();

    @Override
    protected BaseMapper getMapper() {
        return getEntityMapper();
    }

    public void insert(T entity) {
        save(entity);
    }

    public void update(T entity) {
        save(entity);
    }

    public void save(T entity) {
        getEntityMapper().save(entity);
    }

    public void delete(PK id) {
        getEntityMapper().delete(id);
    }

    public T get(PK id) {
        return getEntityMapper().getOne(id);
    }
}
