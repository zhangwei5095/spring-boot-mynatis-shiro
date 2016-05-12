package cn.elvea.persistence.repository;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseEntityRepository<User, Long> {
    User findByUsername(String username);
}
