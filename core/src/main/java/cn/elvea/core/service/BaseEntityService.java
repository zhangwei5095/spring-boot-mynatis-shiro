package cn.elvea.core.service;

import cn.elvea.core.domain.IdEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public interface BaseEntityService<T extends IdEntity, PK extends Serializable> extends BaseService {

    void insert(T entity);

    void update(T entity);

    void save(T entity);

    void delete(PK id);

    T get(PK id);

    Page<T> findAll(Pageable pageable);
}
