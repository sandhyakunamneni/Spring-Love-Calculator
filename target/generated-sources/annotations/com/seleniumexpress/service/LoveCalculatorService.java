package com.seleniumexpress.service;

import org.springframework.stereotype.Service;

@Service
public interface LoveCalculatorService {
	
	public String calculateResult(String userName,String crushName);

}
