package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.EntityRelation;
import cn.elvea.repository.EntityRelationRepository;
import cn.elvea.service.EntityRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntityRelationServiceImpl extends BaseEntityServiceImpl<EntityRelation, Long> implements EntityRelationService {

    @Autowired
    EntityRelationRepository entityRelationRepository;

    @Override
    protected BaseEntityRepository<EntityRelation, Long> getEntityRepository() {
        return entityRelationRepository;
    }
}
