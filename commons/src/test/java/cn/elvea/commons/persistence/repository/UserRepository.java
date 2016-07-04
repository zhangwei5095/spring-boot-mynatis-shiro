package cn.elvea.commons.persistence.repository;

import cn.elvea.commons.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseEntityRepository<User, Long> {
    User findByUsername(String username);
}
