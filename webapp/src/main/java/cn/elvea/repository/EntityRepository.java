package cn.elvea.repository;

import cn.elvea.domain.IdEntity;
import cn.elvea.utils.Page;

import java.io.Serializable;
import java.util.List;

public interface EntityRepository<T extends IdEntity> extends BaseRepository {
    T findById(Serializable key);

    List<T> findByPage(Page<T> page);

    List<T> findAll();

    void insert(T t);

    void update(T t);

    void delete(Serializable key);

}
