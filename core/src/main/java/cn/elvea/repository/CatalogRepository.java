package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Catalog;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends BaseEntityRepository<Catalog, Long> {
}
