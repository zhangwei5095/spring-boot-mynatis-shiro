package cn.elvea.persistence.repository;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseEntityRepository<Role, Long> {
    Role findByCode(String code);
}
