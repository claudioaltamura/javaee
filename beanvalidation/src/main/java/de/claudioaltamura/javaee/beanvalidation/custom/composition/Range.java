package de.claudioaltamura.javaee.beanvalidation.custom.composition;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import de.claudioaltamura.javaee.beanvalidation.custom.minwords.MinWords;

@NotNull
@MinWords(value = 10)
@MaxWords(value = 15)
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface Range {

	String message() default "too short or too long";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
