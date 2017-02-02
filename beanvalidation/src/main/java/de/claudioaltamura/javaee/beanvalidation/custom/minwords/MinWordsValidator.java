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

		if(inclusive)
			isValid = Integer.valueOf(value.length()) >= minValue;
		else
			isValid = Integer.valueOf(value.length()) > minValue;

//		if(!isValid) {
//			constraintValidatorContext.disableDefaultConstraintViolation();
//			constraintValidatorContext
//			.buildConstraintViolationWithTemplate( "{my.custom.template}" )
//			.addPropertyNode( "foreword" ).addConstraintViolation();
//
//		}

		return isValid;
	}

}