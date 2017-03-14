package de.claudioaltamura.javaee.beanvalidation.custom.composition;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class RangeTest {

	@Test
	public void tooLongTooShort() {
		AnotherContent content = new AnotherContent();
		content.setForeword("blabla");

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<AnotherContent>> constraintViolations = validator.validate(content);
		logViolations(constraintViolations);

		assertEquals(2, constraintViolations.size() );
		Iterator<ConstraintViolation<AnotherContent>> iterator = constraintViolations.iterator();
		assertEquals("too short", iterator.next().getMessage());
		assertEquals("too long", iterator.next().getMessage());
	}

	@Test
	public void everythingsIsAlright() {
		AnotherContent content = new AnotherContent();
		content.setForeword("ThisIsaTest....");

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<AnotherContent>> constraintViolations = validator.validate(content);
		logViolations(constraintViolations);

		assertEquals(0, constraintViolations.size() );
	}

	@Test
	public void testNull() {
		AnotherContent content = new AnotherContent();
		content.setForeword(null);

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<AnotherContent>> constraintViolations = validator.validate(content);
		logViolations(constraintViolations);

		assertEquals(3, constraintViolations.size() );
		Iterator<ConstraintViolation<AnotherContent>> iterator = constraintViolations.iterator();
		assertEquals("too long", iterator.next().getMessage());
		assertEquals("too short", iterator.next().getMessage());
		assertEquals("may not be null", iterator.next().getMessage());
	}

}
