package cn.elvea.repository;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Organization;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends BaseEntityRepository<Organization, Long> {
}
