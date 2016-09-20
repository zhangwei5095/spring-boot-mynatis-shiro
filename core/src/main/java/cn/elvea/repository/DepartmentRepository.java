package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends BaseEntityRepository<Department, Long> {
}
