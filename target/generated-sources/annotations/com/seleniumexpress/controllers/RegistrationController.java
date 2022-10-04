package com.seleniumexpress.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.api.UserRegistrationDTO;

@Controller
public class RegistrationController {

    @RequestMapping("/registration")
    public String setRegistrationUser(@ModelAttribute("userRegistrationInfo")UserRegistrationDTO userRegistrationDTO){
        return "registration-page";
    }

    @RequestMapping("/registration-sucess")
    public String registrationSucess(@ModelAttribute("userRegistrationInfo")UserRegistrationDTO registrationDTO){
        return "registration-success";
    }
}
