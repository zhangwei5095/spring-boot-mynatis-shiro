package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.Organization;
import cn.elvea.repository.OrganizationRepository;
import cn.elvea.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganizationServiceImpl extends BaseEntityServiceImpl<Organization, Long> implements OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    protected BaseEntityRepository<Organization, Long> getEntityRepository() {
        return organizationRepository;
    }
}
