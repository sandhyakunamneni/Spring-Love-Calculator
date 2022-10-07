package com.seleniumexpress.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	//check if validator supports dto
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty","User name can't be empty");
		
		String userName=((UserRegistrationDTO)target).getUserName();
		
		if(!userName.contains("_"))
		{
			errors.rejectValue("userName", "userName.inValidString","Username must contain '_'");
		}

	}

}
