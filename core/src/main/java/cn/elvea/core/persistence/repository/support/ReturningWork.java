package cn.elvea.core.persistence.repository.support;

import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;

public interface ReturningWork<T> {
    T execute(EntityManager entityManager) throws DataAccessException;
}
