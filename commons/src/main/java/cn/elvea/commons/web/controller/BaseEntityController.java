package cn.elvea.commons.web.controller;

import cn.elvea.commons.domain.IdEntity;
import cn.elvea.commons.service.BaseService;

import java.io.Serializable;

public abstract class BaseEntityController<T extends IdEntity, PK extends Serializable> extends BaseController {
    protected abstract BaseService getEntityService();

    @Override
    protected BaseService getService() {
        return getEntityService();
    }
}
