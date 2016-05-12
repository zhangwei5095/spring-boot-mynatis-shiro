package cn.elvea.persistence.service;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.core.service.BaseEntityService;
import cn.elvea.domain.Role;
import cn.elvea.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseEntityService<Role, Long> {
    @Autowired
    RoleRepository roleRepository;

    @Override
    protected BaseEntityRepository<Role, Long> getEntityRepository() {
        return roleRepository;
    }
}
