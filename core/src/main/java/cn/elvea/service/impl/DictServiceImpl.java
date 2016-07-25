package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.Dict;
import cn.elvea.repository.DictRepository;
import cn.elvea.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictServiceImpl extends BaseEntityServiceImpl<Dict, Long> implements DictService {

    @Autowired
    DictRepository dictRepository;

    @Override
    protected BaseEntityRepository<Dict, Long> getEntityRepository() {
        return dictRepository;
    }
}
