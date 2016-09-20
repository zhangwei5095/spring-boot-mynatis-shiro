package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.Entity;
import cn.elvea.repository.EntityRepository;
import cn.elvea.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntityServiceImpl extends BaseEntityServiceImpl<Entity, Long> implements EntityService {
    @Autowired
    EntityRepository entityRepository;

    @Override
    protected BaseEntityRepository<Entity, Long> getEntityRepository() {
        return entityRepository;
    }
}
