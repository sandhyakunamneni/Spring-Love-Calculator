package com.seleniumexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();

@Autowired
private JavaMailSender javaMailSenderImpl;

 public void sendEmail (String userEmail, String result,String userName) {
	// TODO Auto-generated method stub
	
	SimpleMailMessage mailMessage= new SimpleMailMessage();
	mailMessage.setTo(userEmail);
	mailMessage.setSubject("Love Calculator Application result");
	mailMessage.setText("Hi"+userName+ "I love you");
	javaMailSenderImpl.send(mailMessage);
	
	
}

}
