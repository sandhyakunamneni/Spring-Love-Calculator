package com.seleniumexpress.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.api.UserRegistrationDTO;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String setRegistrationUser(@ModelAttribute("userRegistrationInfo")UserRegistrationDTO userRegistrationDTO){
        return "registration-page";
    }

    @RequestMapping("/registration-sucess")
    public String registrationSucess(@Valid @ModelAttribute("userRegistrationInfo")UserRegistrationDTO registrationDTO, BindingResult result){
       if(result.hasErrors())
       {
    	   List<ObjectError> allErrors=result.getAllErrors();
    	   for(ObjectError err:allErrors)
    	   {
    		   System.out.println(err);
    	   }
    	   return "registration-page";
       }
    	
    	return "registration-success";
    }
}
