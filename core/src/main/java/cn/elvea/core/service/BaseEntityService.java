package cn.elvea.core.service;

import cn.elvea.core.domain.IdEntity;
import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.core.persistence.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public abstract class BaseEntityService<T extends IdEntity, PK extends Serializable> extends BaseService {
    protected abstract BaseEntityRepository<T, PK> getEntityRepository();

    @Override
    protected BaseRepository getRepository() {
        return getEntityRepository();
    }

    public void insert(T entity) {
        save(entity);
    }

    public void update(T entity) {
        save(entity);
    }

    public void save(T entity) {
        getEntityRepository().save(entity);
    }

    public void delete(PK id) {
        getEntityRepository().delete(id);
    }

    public T get(PK id) {
        return getEntityRepository().getOne(id);
    }

    public Page<T> findAll(Pageable pageable) {
        return getEntityRepository().findAll(pageable);
    }
}
