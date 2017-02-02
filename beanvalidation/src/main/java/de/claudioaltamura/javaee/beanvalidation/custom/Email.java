package de.claudioaltamura.javaee.beanvalidation.custom;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint( validatedBy = EmailValidator.class )
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention( RUNTIME )
@Documented
public @interface Email
{
  String message() default "no valid email address";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}