package cn.elvea.commons.persistence.mapper;

import cn.elvea.commons.domain.Role;
import cn.elvea.commons.persistence.mybatis.mapper.BaseEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends BaseEntityMapper<Role, Long> {
}
