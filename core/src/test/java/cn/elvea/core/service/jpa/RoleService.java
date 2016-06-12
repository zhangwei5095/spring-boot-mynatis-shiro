package cn.elvea.core.service.jpa;

import cn.elvea.core.domain.Role;
import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.core.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseJpaEntityService<Role, Long> {
    @Autowired
    RoleRepository roleRepository;

    @Override
    protected BaseEntityRepository<Role, Long> getEntityRepository() {
        return roleRepository;
    }
}
