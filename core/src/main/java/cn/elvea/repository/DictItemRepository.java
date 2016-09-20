package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.DictItem;
import org.springframework.stereotype.Repository;

@Repository
public interface DictItemRepository extends BaseEntityRepository<DictItem, Long> {
}
