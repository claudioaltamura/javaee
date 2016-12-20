package de.claudioaltamura.javaee.beanvalidation.groups.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class AuthorTest {

	@Test
	public void name() {
		Validator v = Validation.buildDefaultValidatorFactory().getValidator();

		Author author = new Author();

		Set<ConstraintViolation<Author>> constraintViolations = v.validate(author, Author.NameValidation.class);
		logViolations(constraintViolations);

		assertTrue(constraintViolations.size()==1);
	}

	@Test
	public void nameAndAge() {
		Validator v = Validation.buildDefaultValidatorFactory().getValidator();

		Author author = new Author();

		Set<ConstraintViolation<Author>> constraintViolations = v.validate(author, Author.AgeValidation.class);
		logViolations(constraintViolations);

		//Name and age through extends
		assertTrue(constraintViolations.size()==2);

	}
}
