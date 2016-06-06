package cn.elvea.repository;

import cn.elvea.domain.User;
import cn.elvea.core.persistence.repository.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseEntityRepository<User, Long> {
    User findByEmployeeNumber(String username);
}
