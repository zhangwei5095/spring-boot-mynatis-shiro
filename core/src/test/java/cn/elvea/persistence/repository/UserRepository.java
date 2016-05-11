package cn.elvea.persistence.repository;

import cn.elvea.core.persistence.repository.BaseRepository;
import cn.elvea.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}
