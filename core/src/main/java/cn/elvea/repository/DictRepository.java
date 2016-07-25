package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Dict;
import org.springframework.stereotype.Repository;

@Repository
public interface DictRepository extends BaseEntityRepository<Dict, Long> {
}
