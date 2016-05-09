package cn.elvea.persistence.jpa.repository;

import cn.elvea.core.persistence.jpa.repository.BaseRepository;
import cn.elvea.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}
