package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends BaseEntityRepository<Position, Long> {
}
