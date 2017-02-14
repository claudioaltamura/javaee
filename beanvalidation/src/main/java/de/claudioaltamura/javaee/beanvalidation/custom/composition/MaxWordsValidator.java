package de.claudioaltamura.javaee.beanvalidation.custom.composition;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxWordsValidator implements ConstraintValidator<MaxWords, String> {

	private long maxValue;
	private boolean inclusive;

	@Override
	public void initialize(MaxWords constraintAnnotation) {
		maxValue = constraintAnnotation.value();
		inclusive = constraintAnnotation.inclusive();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		boolean isValid;

		if(value == null)
			return false;

		if(inclusive)
			isValid = Integer.valueOf(value.length()) >= maxValue;
		else
			isValid = Integer.valueOf(value.length()) > maxValue;

		return isValid;
	}

}