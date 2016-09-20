package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.CatalogAccess;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogAccessRepository extends BaseEntityRepository<CatalogAccess, Long> {
}
