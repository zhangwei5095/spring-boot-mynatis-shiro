package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.ResourceAccess;
import cn.elvea.repository.ResourceAccessRepository;
import cn.elvea.service.ResourceAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResourceAccessServiceImpl extends BaseEntityServiceImpl<ResourceAccess, Long> implements ResourceAccessService {

    @Autowired
    ResourceAccessRepository resourceAccessRepository;

    @Override
    protected BaseEntityRepository<ResourceAccess, Long> getEntityRepository() {
        return resourceAccessRepository;
    }
}
