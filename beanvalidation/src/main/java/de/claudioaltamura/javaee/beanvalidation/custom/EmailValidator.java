package de.claudioaltamura.javaee.beanvalidation.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public void initialize(Email constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.matches("[\\w|-]+@\\w[\\w|-]*\\.[a-z]{2,3}");
	}
}