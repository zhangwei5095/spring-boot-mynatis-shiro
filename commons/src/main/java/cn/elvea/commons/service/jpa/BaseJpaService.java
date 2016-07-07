package cn.elvea.commons.service.jpa;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseJpaService implements BaseService {
    protected BaseEntityRepository repository;

    protected abstract BaseEntityRepository getRepository();
}
