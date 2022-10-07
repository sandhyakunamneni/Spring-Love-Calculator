package com.seleniumexpress.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.api.UserRegistrationDTO;
import com.seleniumexpress.propertyeditors.StringUpperCaseEditor;
import com.seleniumexpress.validators.EmailValidator;
import com.seleniumexpress.validators.UserNameValidator;

@Controller
public class RegistrationController {

	@Autowired
	private EmailValidator emailValidator;
	
    @RequestMapping("/register")
    public String setRegistrationUser(@ModelAttribute("userRegistrationInfo")UserRegistrationDTO userRegistrationDTO){
        return "registration-page";
    }

    @RequestMapping("/registration-sucess")
    public String registrationSucess(@Valid @ModelAttribute("userRegistrationInfo")UserRegistrationDTO registrationDTO, BindingResult result){
       
//    	EmailValidator emailValidator= new EmailValidator();
    	emailValidator.validate(registrationDTO, result);
    	
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
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
//    	dataBinder.setDisallowedFields("name");
    	StringTrimmerEditor editor= new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class, "name",editor);
    	
    	StringUpperCaseEditor upperCaseEditor = new StringUpperCaseEditor();
    	dataBinder.registerCustomEditor(String.class, "name",upperCaseEditor);
    	
    	UserNameValidator nameValidator= new UserNameValidator();
    	dataBinder.addValidators(nameValidator);
    	
//    	EmailValidator emailValidator= new EmailValidator();
//    	dataBinder.addValidators(emailValidator);
    }
}
