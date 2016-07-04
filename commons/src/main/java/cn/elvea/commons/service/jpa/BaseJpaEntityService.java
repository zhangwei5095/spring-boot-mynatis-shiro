package cn.elvea.commons.service.jpa;

import cn.elvea.commons.domain.IdEntity;
import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.persistence.repository.BaseRepository;
import cn.elvea.commons.service.BaseEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public abstract class BaseJpaEntityService<T extends IdEntity, PK extends Serializable> extends BaseJpaService implements BaseEntityService<T, PK> {
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
