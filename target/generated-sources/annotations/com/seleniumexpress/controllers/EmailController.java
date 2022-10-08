package com.seleniumexpress.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.seleniumexpress.api.EmailDTO;
import com.seleniumexpress.api.UserInfoDTO;
import com.seleniumexpress.service.EmailService;
import com.seleniumexpress.service.EmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	// using path variable to store userName

//	@RequestMapping("/email/{userName}")
//	public String showEmailPage(@PathVariable("userName") String userName,
//			@ModelAttribute("emailDTO") EmailDTO emailDTO, Model model) {
//		model.addAttribute("userName", userName.toUpperCase());
//		return "email-page";
//	}

	//using cookies to get username
//	@RequestMapping("/email")
//	public String showEmailPage(@CookieValue("userName") String userName,
//			@ModelAttribute("emailDTO") EmailDTO emailDTO,Model model) {
//      model.addAttribute("userName", userName);
//		return "email-page";
//
//	}
	
	@RequestMapping("/email")
	public String showEmailPage(
			@ModelAttribute("emailDTO") EmailDTO emailDTO) {
      
		return "email-page";

	}
 
	//using session to change username if required
// 
//	@RequestMapping("/sendemail")
//	public String emailSentPage(@ModelAttribute("emailDTO") EmailDTO emailDTO,HttpSession session,Model model) {
//
//		String userName="Ms. "+session.getAttribute("userName");
//		model.addAttribute("userName1", userName);
//		return "emailSuccessPage";
//	}
	
	@RequestMapping("/sendemail")
	public String emailSentPage(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO,@ModelAttribute("emailDTO") EmailDTO emailDTO) {
         
		
		emailService.sendEmail(emailDTO.getUserEmail(),"FRIEND",userInfoDTO.getUserName());
	
		return "emailSuccessPage";
	}

}
