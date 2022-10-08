package com.seleniumexpress.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	void sendEmail(String userEmail, String result, String userName) ;

}
