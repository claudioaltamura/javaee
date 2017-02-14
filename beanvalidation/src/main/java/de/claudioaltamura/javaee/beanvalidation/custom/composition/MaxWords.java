package de.claudioaltamura.javaee.beanvalidation.custom.composition;

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
@Constraint(validatedBy = MaxWordsValidator.class)
public @interface MaxWords {

	String message() default "too long";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	long value();

	boolean inclusive() default true;

}
