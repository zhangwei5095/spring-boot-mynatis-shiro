package cn.elvea.commons.persistence.dao;

import cn.elvea.commons.domain.User;
import org.springframework.stereotype.Repository;

@Repository(value = "jdbcUserDao")
public class UserDao extends BaseEntityDao<User, Long> {
}
