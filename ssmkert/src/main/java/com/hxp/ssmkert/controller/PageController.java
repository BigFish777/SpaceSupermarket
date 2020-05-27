package com.hxp.ssmkert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 10:55
 * \
 */
@Controller
public class PageController {

    @GetMapping("/login.html")
    public String login(){
     return "login";
    }

    @GetMapping("/login-erweima.html")
    public String loginErweima(){
        return "login-erweima";
    }

    @GetMapping("/login-from.html")
    public String loginFrom(){
        return "login-from";
    }
}
