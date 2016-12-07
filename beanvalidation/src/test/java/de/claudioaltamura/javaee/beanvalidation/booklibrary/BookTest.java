package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class BookTest {

	@Test
	public void testGetName() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Book book = new Book();
		LocalDate date = LocalDate.now();
		date.plusDays(1);
		book.setDate(Date.valueOf(date));

		Set<ConstraintViolation<Book>> violations = validator.validate(book);

		logViolations(violations);

		assertEquals(violations.isEmpty(), false);
	}

}
