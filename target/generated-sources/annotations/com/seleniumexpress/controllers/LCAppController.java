package com.seleniumexpress.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.api.UserInfoDTO;

@Controller
public class LCAppController {

    @RequestMapping("/")
    public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO)
    {
System.out.println("called");
        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String showResultPage (@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError temp:allErrors) {
                System.out.println(temp);
            }
            return "home-page";
        }
        return "result-page";
    }

}
