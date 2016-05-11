package cn.elvea.persistence.repository;

import cn.elvea.core.persistence.repository.BaseRepository;
import cn.elvea.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
}
