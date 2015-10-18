package cn.elvea.repository;

import cn.elvea.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserRepository extends EntityRepository<User> {
    User findByUsername(@Param("username") String username);

    User findByEmail(@Param("email") String email);
}
