package cn.elvea.controller;

import cn.elvea.domain.UserSession;
import cn.elvea.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/admin/user/session"})
public class UserSessionController {
    @Autowired
    UserSessionService userSessionService;

    @RequestMapping(value = {"index"})
    public String index() {
        return "session/index";
    }

    @RequestMapping(value = {"list"})
    @ResponseBody
    public Page<UserSession> list(Pageable pageable) {
        Page<UserSession> page = this.userSessionService.findAll(pageable);
        return page;
    }
}
