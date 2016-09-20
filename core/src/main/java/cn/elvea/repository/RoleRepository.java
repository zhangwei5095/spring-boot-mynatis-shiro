package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseEntityRepository<Role, Long> {
}
