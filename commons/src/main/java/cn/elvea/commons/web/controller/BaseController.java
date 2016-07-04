package cn.elvea.commons.web.controller;

import cn.elvea.commons.service.BaseService;

public abstract class BaseController {
    protected abstract BaseService getService();
}
