package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.Department;
import cn.elvea.repository.DepartmentRepository;
import cn.elvea.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl extends BaseEntityServiceImpl<Department, Long> implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    protected BaseEntityRepository<Department, Long> getEntityRepository() {
        return departmentRepository;
    }
}
