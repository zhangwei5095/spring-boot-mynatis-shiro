package cn.elvea.core.web.controller;

import cn.elvea.core.service.BaseService;

public abstract class BaseController {
    protected abstract BaseService getService();
}
