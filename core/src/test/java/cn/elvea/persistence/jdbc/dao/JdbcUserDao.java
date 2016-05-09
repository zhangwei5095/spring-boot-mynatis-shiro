package cn.elvea.persistence.jdbc.dao;

import cn.elvea.core.persistence.jdbc.BaseEntityDao;
import cn.elvea.entity.User;
import org.springframework.stereotype.Repository;

@Repository(value = "jdbcUserDao")
public class JdbcUserDao extends BaseEntityDao<User, Long> {
}
