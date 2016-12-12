package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
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
		book.setDate(Date.valueOf(date.plusDays(1)));
		book.setIsbn("dsf"); //978-3423261272
		book.setPrice(new BigDecimal("-0.01"));
		book.setPages(-1);
		System.out.println(book);

		Set<ConstraintViolation<Book>> violations = validator.validate(book);

		logViolations(violations);

		assertEquals(violations.isEmpty(), false);
	}

}
