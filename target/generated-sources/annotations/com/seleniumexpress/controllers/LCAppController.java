package com.seleniumexpress.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.api.UserInfoDTO;
import com.seleniumexpress.service.LoveCalculatorService;

@Controller
@SessionAttributes("userInfo")
public class LCAppController {

	@Autowired
	private LoveCalculatorService loveCalculatorService;

	@RequestMapping("/")
	public String showHomePage(HttpServletRequest request, Model model) {
		System.out.println("called");

		model.addAttribute("userInfo", new UserInfoDTO());

		// using cookie to set username (on refresh)

//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			if ("userName".equals(cookie.getName())) {
//				userInfoDTO.setUserName(cookie.getValue());
//			}
//		}
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO,
			BindingResult bindingResult, HttpServletResponse response, HttpServletRequest request,Model model) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			return "home-page";
		}

		String result=loveCalculatorService.calculateResult(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		
		model.addAttribute("result", result);
		// get session to store userName
//		HttpSession session = request.getSession();
//		
//		session.setAttribute("userName",  userInfoDTO.getUserName());
//
//		session.setMaxInactiveInterval(120);

//		// create a cookie
//		Cookie cookie = new Cookie("userName", userInfoDTO.getUserName());
//		cookie.setMaxAge(60 * 60 * 24);
//		response.addCookie(cookie);

		return "result-page";
	}

}
