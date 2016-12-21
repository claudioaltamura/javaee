package de.claudioaltamura.javaee.beanvalidation.groups.booklibrary;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import de.claudioaltamura.javaee.beanvalidation.groups.booklibrary.Publisher.PublisherValidation;

public class PublisherTest {

	@Test
	public void name() {
		Validator v = Validation.buildDefaultValidatorFactory().getValidator();

		Publisher publisher = new Publisher();
		publisher.setName("");
		publisher.setAuthors(new ArrayList<Author>());

		Set<ConstraintViolation<Publisher>> constraintViolations = v.validate(publisher, PublisherValidation.class);
		logViolations(constraintViolations);

		assertTrue(constraintViolations.size()==1);
	}

}
