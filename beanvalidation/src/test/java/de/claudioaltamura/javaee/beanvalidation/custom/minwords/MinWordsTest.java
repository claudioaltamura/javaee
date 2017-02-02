package de.claudioaltamura.javaee.beanvalidation.custom.minwords;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class MinWordsTest {

	@Test
	public void test() {
		Content content = new Content();
		content.setForeword("blabla");

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		Set<ConstraintViolation<Content>> constraintViolations = validator.validate(content);
		logViolations(constraintViolations);

		assertEquals( 1, constraintViolations.size() );
		assertEquals("too short", constraintViolations.iterator().next().getMessage()
		);

	}


}
