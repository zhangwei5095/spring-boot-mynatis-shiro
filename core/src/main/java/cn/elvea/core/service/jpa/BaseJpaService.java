package cn.elvea.core.service.jpa;

import cn.elvea.core.persistence.repository.BaseRepository;
import cn.elvea.core.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseJpaService implements BaseService {
    protected BaseRepository repository;

    protected abstract BaseRepository getRepository();
}
