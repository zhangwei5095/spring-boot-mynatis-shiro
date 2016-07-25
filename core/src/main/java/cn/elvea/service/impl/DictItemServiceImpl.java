package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.DictItem;
import cn.elvea.repository.DictItemRepository;
import cn.elvea.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictItemServiceImpl extends BaseEntityServiceImpl<DictItem, Long> implements DictItemService {
    @Autowired
    DictItemRepository dictItemRepository;

    @Override
    protected BaseEntityRepository<DictItem, Long> getEntityRepository() {
        return dictItemRepository;
    }
}
