package cn.elvea.service;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseJpaEntityService;
import cn.elvea.domain.Permission;
import cn.elvea.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionService extends BaseJpaEntityService<Permission, Long> {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    protected BaseEntityRepository<Permission, Long> getEntityRepository() {
        return permissionRepository;
    }

    public boolean exists(String code) {
        return false;
    }

    public Permission findByCode(String code) {
        return permissionRepository.findOne(1l);
    }
}
