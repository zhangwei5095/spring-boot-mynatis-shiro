package cn.elvea.commons.service.mybatis;

import cn.elvea.commons.domain.IdEntity;
import cn.elvea.commons.persistence.mybatis.mapper.BaseEntityMapper;
import cn.elvea.commons.persistence.mybatis.mapper.BaseMapper;
import cn.elvea.commons.service.BaseEntityService;
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
