package de.claudioaltamura.javaee.beanvalidation.custom;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		Validator v = Validation.buildDefaultValidatorFactory().getValidator();

		Person p = new Person();

		Set<ConstraintViolation<Person>> constraintViolations = v.validate(p);
		logViolations(constraintViolations);

		assertTrue(constraintViolations.size()==2);
	}

}
