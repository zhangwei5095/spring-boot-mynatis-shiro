package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.EntityRelation;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRelationRepository extends BaseEntityRepository<EntityRelation, Long> {
}
