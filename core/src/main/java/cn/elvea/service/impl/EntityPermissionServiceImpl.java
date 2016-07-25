package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.EntityPermission;
import cn.elvea.repository.EntityPermissionRepository;
import cn.elvea.service.EntityPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntityPermissionServiceImpl extends BaseEntityServiceImpl<EntityPermission, Long> implements EntityPermissionService {

    @Autowired
    EntityPermissionRepository entityPermissionRepository;

    @Override
    protected BaseEntityRepository<EntityPermission, Long> getEntityRepository() {
        return entityPermissionRepository;
    }
}
