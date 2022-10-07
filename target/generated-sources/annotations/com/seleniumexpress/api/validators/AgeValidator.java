package com.seleniumexpress.api.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;

	@Override
	public void initialize(Age age) {

		// post construct work
		this.upper = age.upper();
		this.lower = age.lower();

	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (value == null) {
			return false;
		}
		if (this.lower > value || this.upper < value) {
			return false;
		}
		return true;
	}

}
