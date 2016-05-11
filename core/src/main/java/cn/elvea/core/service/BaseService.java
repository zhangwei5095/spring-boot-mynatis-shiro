package cn.elvea.core.service;

import cn.elvea.core.persistence.repository.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseService {
    protected BaseRepository repository;

    protected abstract BaseRepository getRepository();
}
