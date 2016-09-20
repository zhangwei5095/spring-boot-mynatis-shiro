package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Entity;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends BaseEntityRepository<Entity, Long> {
}
