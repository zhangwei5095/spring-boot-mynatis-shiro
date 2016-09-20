package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.CatalogRelation;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRelationRepository extends BaseEntityRepository<CatalogRelation, Long> {
}
