package com.seleniumexpress.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.api.UserRegistrationDTO;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "communicationDTO.email.empty",
				"Email can't be empty");
		String email = ((UserRegistrationDTO) target).getCommunicationDTO().getEmail();
		if (!email.endsWith("@seleniumexpress.com")) {
			errors.rejectValue("communicationDTO.email", "communicationDTO.email.inValidString",
					"Email must end with seleniumexpress.com");
		}
	}

}
