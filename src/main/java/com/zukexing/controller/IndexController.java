package com.zukexing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 进入主页面
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping("/policy/service")
    public String service() {
        return "service";
    }

    @RequestMapping("/policy/privacy")
    public String privacy() {
        return "privacy";
    }
}
