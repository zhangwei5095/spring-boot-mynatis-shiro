package cn.elvea.core.service.mybatis;

import cn.elvea.core.persistence.mybatis.mapper.BaseMapper;
import cn.elvea.core.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseMybatisService implements BaseService {
    protected BaseMapper mapper;

    protected abstract BaseMapper getMapper();
}
