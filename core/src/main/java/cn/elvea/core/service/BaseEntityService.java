package cn.elvea.core.service;

import cn.elvea.core.persistence.IdEntity;
import cn.elvea.core.persistence.repository.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public abstract class BaseEntityService<T extends IdEntity, PK extends Serializable> extends BaseService {
    protected BaseRepository repository;

    protected abstract BaseRepository getRepository();

    public void insert(T entity) {
        save(entity);
    }

    public void update(T entity) {
        save(entity);
    }

    public void save(T entity) {
        getRepository().save(entity);
    }

    public void delete(PK id) {
        getRepository().delete(id);
    }

    public T get(PK id) {
        return (T) getRepository().getOne(id);
    }
}
