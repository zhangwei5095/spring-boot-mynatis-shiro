package cn.elvea.commons.persistence.repository.support;

import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;

public interface Callback {
    void execute(EntityManager entityManager) throws DataAccessException;
}
