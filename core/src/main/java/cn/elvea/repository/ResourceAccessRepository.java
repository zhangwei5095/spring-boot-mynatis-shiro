package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.ResourceAccess;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceAccessRepository extends BaseEntityRepository<ResourceAccess, Long> {
}
