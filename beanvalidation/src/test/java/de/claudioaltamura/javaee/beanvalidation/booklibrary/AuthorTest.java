package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class AuthorTest {

	@Test
	public void testWithValid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Author author = new Author();
		author.setEmail("dbad.de");
		List<Book> books = new ArrayList<>();
		Book book = new Book();
		books.add(book);
		author.setBooks(books);

		Set<ConstraintViolation<Author>> violations = validator.validate(author);

		logViolations(violations);

		assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void testSingleProperty() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Author author = new Author();
		author.setEmail("dbad.de");
		Set<ConstraintViolation<Author>> validatedProperty = validator.validateProperty(author, "email");

		assertTrue(validatedProperty.size()==1);
	}

}
