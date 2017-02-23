package de.claudioaltamura.javaee.beanvalidation.custom.crossparameter;

import java.time.ZonedDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentDateParametersValidator implements ConstraintValidator<ConsistentDateParameters, Object[]> {

	@Override
	public void initialize(ConsistentDateParameters constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object[] value, ConstraintValidatorContext context) {
		if ( value.length != 2 ) {
			throw new IllegalArgumentException( "Illegal method signature" );
		}

		//leave null-checking to @NotNull on individual parameters
		if ( value[0] == null || value[1] == null ) {
			return true;
		}

		if ( !( value[0] instanceof ZonedDateTime ) || !( value[1] instanceof ZonedDateTime ) ) {
			throw new IllegalArgumentException(
					"Illegal method signature, expected two " +
							"parameters of type ZonedDateTime."
			);
		}

		return ( (ZonedDateTime) value[0] ).isBefore( (ZonedDateTime) value[1] );
	}
}