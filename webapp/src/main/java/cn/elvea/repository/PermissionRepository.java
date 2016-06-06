package cn.elvea.repository;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends BaseEntityRepository<Permission, Long> {
}
