package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.CatalogAccess;
import cn.elvea.repository.CatalogAccessRepository;
import cn.elvea.service.CatalogAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogAccessServiceImpl extends BaseEntityServiceImpl<CatalogAccess, Long> implements CatalogAccessService {
    @Autowired
    CatalogAccessRepository catalogAccessRepository;

    @Override
    protected BaseEntityRepository<CatalogAccess, Long> getEntityRepository() {
        return catalogAccessRepository;
    }
}
