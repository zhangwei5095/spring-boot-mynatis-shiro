package cn.elvea.core.persistence.repository.support;

import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;

public interface Work {
    void execute(EntityManager entityManager) throws DataAccessException;
}
