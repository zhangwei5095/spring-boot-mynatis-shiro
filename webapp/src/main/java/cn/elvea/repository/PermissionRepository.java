package cn.elvea.repository;

import cn.elvea.domain.Permission;
import org.apache.ibatis.annotations.Param;

public interface PermissionRepository extends EntityRepository<Permission> {
    Permission findByCode(@Param("code") String code);
}
