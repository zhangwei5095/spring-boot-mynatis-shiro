package cn.elvea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationController {
    @RequestMapping(value = {"/org/index"})
    public String index() {
        return "org/index";
    }
}
