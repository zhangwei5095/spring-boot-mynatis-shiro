package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Resource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends BaseEntityRepository<Resource, Long> {
}
