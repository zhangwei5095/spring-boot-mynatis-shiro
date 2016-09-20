package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.CatalogRelation;
import cn.elvea.repository.CatalogRelationRepository;
import cn.elvea.service.CatalogRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogRelationServiceImpl extends BaseEntityServiceImpl<CatalogRelation, Long> implements CatalogRelationService {

    @Autowired
    CatalogRelationRepository catalogRelationRepository;

    @Override
    protected BaseEntityRepository<CatalogRelation, Long> getEntityRepository() {
        return catalogRelationRepository;
    }
}
