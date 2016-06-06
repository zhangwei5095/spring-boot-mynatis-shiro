package cn.elvea.core.persistence.repository;

import cn.elvea.core.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseEntityRepository<Role, Long> {
    Role findByCode(String code);
}
