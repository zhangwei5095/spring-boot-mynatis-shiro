package cn.elvea.core.web.controller;

import cn.elvea.core.domain.IdEntity;
import cn.elvea.core.service.BaseService;

import java.io.Serializable;

public abstract class BaseEntityController<T extends IdEntity, PK extends Serializable> extends BaseController {
    protected abstract BaseService getEntityService();

    @Override
    protected BaseService getService() {
        return getEntityService();
    }
}
