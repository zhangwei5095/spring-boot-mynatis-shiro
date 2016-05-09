package cn.elvea.core.persistence.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public abstract class BaseDao {
    @Autowired
    private EntityManager entityManager;
}
