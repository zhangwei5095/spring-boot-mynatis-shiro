package cn.elvea.core.persistence.dao;

import cn.elvea.core.domain.User;
import org.springframework.stereotype.Repository;

@Repository(value = "jdbcUserDao")
public class UserDao extends BaseEntityDao<User, Long> {
}
