package cn.elvea.commons.service.mybatis;

import cn.elvea.commons.persistence.mybatis.mapper.BaseMapper;
import cn.elvea.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseMybatisService implements BaseService {
    protected BaseMapper mapper;

    protected abstract BaseMapper getMapper();
}
