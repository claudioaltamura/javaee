package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class AuthorTest {

	@Test
	public void testGetName() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Author author = new Author();
		author.setEmail("dbad.de");

		Set<ConstraintViolation<Author>> violations = validator.validate(author);

		logViolations(violations);

		assertEquals(violations.isEmpty(), false);
	}

}
