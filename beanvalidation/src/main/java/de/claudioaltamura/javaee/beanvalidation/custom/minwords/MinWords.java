package de.claudioaltamura.javaee.beanvalidation.custom.minwords;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = MinWordsValidator.class)
public @interface MinWords {

	String message() default "too short";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	long value();

	boolean inclusive() default true;

}
