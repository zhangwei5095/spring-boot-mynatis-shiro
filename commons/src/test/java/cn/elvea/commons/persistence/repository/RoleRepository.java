package cn.elvea.commons.persistence.repository;

import cn.elvea.commons.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseEntityRepository<Role, Long> {
    Role findByCode(String code);
}
