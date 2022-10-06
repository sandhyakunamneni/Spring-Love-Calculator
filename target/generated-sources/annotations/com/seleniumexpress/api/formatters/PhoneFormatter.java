package com.seleniumexpress.api.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.api.Phone;

public class PhoneFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		
		return object.getCountryCode()+"-"+object.getUserNumber();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		String PhoneNumberArray[]= text.split("-");
		Phone phone= new Phone();
		if(text.indexOf('-')==-1)
		{
			phone.setCountryCode("91");
			phone.setUserNumber(PhoneNumberArray[0]);
		}
		else if(text.indexOf('-')==0)
		{
			phone.setCountryCode("91");
			phone.setUserNumber(PhoneNumberArray[1]);
		}
		else
		{
			phone.setCountryCode(PhoneNumberArray[0]);
			phone.setUserNumber(PhoneNumberArray[1]);
		}
		return phone;
	}

}
