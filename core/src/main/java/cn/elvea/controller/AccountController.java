package cn.elvea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端用户账号控制器
 */
@Controller
public class AccountController {
    @RequestMapping(value = {"/profile", "/admin/profile"})
    public String profile() {
        return "profile";
    }

    @RequestMapping(value = {"/account", "/admin/account"})
    public String account() {
        return "account";
    }
}
