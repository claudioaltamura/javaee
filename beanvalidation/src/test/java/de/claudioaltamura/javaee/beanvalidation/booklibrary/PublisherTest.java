package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class PublisherTest {

	@Test
	public void test() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Publisher publisher = new Publisher();
		List<Book> books = new ArrayList<>();
		Book book = new Book();
		book.setPages(100);
		books.add(book);
		publisher.setBooks(books);
		List<Author> authors = new ArrayList<>();
		Author author = new Author();
		author.setName("Arthur");
		author.setBooks(Arrays.asList(new Book()));
		authors.add(author);
		publisher.setAuthors(authors);

		Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);

		logViolations(violations);

		assertEquals(violations.isEmpty(), false);
	}

}
