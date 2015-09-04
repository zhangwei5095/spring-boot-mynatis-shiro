package cn.elvea.repository;

import cn.elvea.domain.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleRepository extends EntityRepository<Role> {
    Role findByCode(@Param("code") String code);
}
