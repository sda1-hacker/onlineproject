package com.online.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("showLoginPage")
    public String showLoginPage(){
        return "loginPage";
    }

    @GetMapping("showRegistPage")
    public String showRegistPage(){
        return "registPage";
    }

    @GetMapping("showIndexPage")
    public String showIndexPage(){
        return "indexPage";
    }
}
