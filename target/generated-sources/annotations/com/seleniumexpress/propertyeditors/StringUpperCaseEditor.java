package com.seleniumexpress.propertyeditors;

import java.beans.PropertyEditorSupport;

public class StringUpperCaseEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String upperCaseText=text.toUpperCase();
		setValue(upperCaseText);
	}

}
