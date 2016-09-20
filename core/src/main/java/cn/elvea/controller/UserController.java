package cn.elvea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后端用户账号控制器
 */
@Controller
public class UserController {
    @RequestMapping(value = {"/admin/user/index"})
    public String index() {
        return "user/index";
    }
}
