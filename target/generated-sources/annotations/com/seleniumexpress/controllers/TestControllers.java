package com.seleniumexpress.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestControllers {

    @RequestMapping("/test")
    public String sayHello(){

        return "hello-world";
    }
}
