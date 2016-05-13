package cn.elvea.core.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseEntityMapper<T, PK extends Serializable> extends BaseMapper {
    void insert(T entity);

    void update(T entity);

    void delete(@Param("id") PK id);

    T get(@Param("id") PK id);

    List<T> findByPage(Pageable pageable);
}
