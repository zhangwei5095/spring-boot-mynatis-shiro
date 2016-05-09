package cn.elvea.persistence.jpa.repository;

import cn.elvea.core.persistence.jpa.repository.BaseRepository;
import cn.elvea.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository extends BaseRepository<Role, Long> {
}
