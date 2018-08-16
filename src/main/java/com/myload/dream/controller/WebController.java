package com.myload.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: putao
 * @Date: 2018/8/13
 */
@Controller
public class WebController {



    @RequestMapping("/")
    public String start() {
        return "mine";
    }


    @RequestMapping("/star")
    public String star() {
        return "star";
    }

    @RequestMapping("/sendyou")
    public String sendyou() {
        return "sendyou";
    }

}
