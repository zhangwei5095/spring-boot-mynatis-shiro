package cn.elvea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("acl")
public class AclController {
    @RequestMapping("index")
    public String index() {
        return "acl/index";
    }
}
