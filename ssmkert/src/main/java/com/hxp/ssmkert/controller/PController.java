package com.hxp.ssmkert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 10:09
 * \
 */
@RestController
public class PController {

    @GetMapping("/p/p1")
    public String p1(){
        return "p1";
    }

    @GetMapping("/p/p2")
    public String p2(){
        return "p2";
    }

}
