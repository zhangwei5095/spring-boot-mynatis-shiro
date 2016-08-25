package cn.elvea.commons.service.jpa;

import cn.elvea.commons.domain.Role;
import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.persistence.repository.RoleRepository;
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
