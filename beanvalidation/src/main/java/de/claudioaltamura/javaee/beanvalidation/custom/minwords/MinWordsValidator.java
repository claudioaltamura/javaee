package de.claudioaltamura.javaee.beanvalidation.custom.minwords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinWordsValidator implements ConstraintValidator<MinWords, String> {

	private long minValue;
	private boolean inclusive;

	@Override
	public void initialize(MinWords constraintAnnotation) {
		minValue = constraintAnnotation.value();
		inclusive = constraintAnnotation.inclusive();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		boolean isValid;

		if(value == null)
			return false;

		if(inclusive)
			isValid = Integer.valueOf(value.length()) >= minValue;
		else
			isValid = Integer.valueOf(value.length()) > minValue;

		return isValid;
	}

}