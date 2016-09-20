package cn.elvea.commons.persistence.mapper;

import cn.elvea.commons.domain.User;
import cn.elvea.commons.persistence.mybatis.mapper.BaseEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseEntityMapper<User, Long> {
}
