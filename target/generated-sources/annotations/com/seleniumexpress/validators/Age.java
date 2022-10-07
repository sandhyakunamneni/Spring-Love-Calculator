package com.seleniumexpress.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int lower() default 0;

	int upper() default 60;

	String message() default "{invalidAgeMessage}";

}
