package de.claudioaltamura.javaee.beanvalidation.user;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		User user = new User();
		user.setWorking(true);
		user.setAboutMe("Its all about me!");
		user.setAge(50);

		Set<ConstraintViolation<User>> violations = validator.validate(user);

		logViolations(violations);

		assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void ifNameIsNull_nameValidationFails() {
		User user = new User();
		user.setWorking(true);
		user.setAboutMe("Its all about me!!");
		user.setAge(50);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void ifSizeNotInRange_aboutMeValidationFails() {
		User user = new User();
		user.setName("MyName");
		user.setAboutMe("Its all about me!!");
		user.setAge(50);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void ifWorkingIsFalse_workingValidationFails() {
		User user = new User();
		user.setName("MyName");
		user.setAboutMe("Its all about me!!");
		user.setAge(50);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void ifAgeNotRange_ageValidationFails() {
		User user = new User();
		user.setName("MyName");
		user.setAboutMe("Its all about me!!");
		user.setAge(8);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertEquals(violations.isEmpty(), false);
	}

	@Test
	public void ifFnameNullAgeNotRangeAndWorkingIsFalse_validationFailsWithThreeErrors() {
		User user = new User();
		user.setAboutMe("Its all about me!!");
		user.setAge(300);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		logViolations(violations);
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 3);
	}

}
