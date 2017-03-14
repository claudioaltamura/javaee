package de.claudioaltamura.javaee.beanvalidation;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;

public class BeanvalidationTestUtils {

	private final static Logger LOGGER = Logger.getLogger(BeanvalidationTestUtils.class.getName());

	private BeanvalidationTestUtils() {
	}

	public static <T> void logViolations(Set<ConstraintViolation<T>> violations) {
		for (ConstraintViolation<T> violation : violations) {
			String invalidValue = violation.getInvalidValue() != null ? violation.getInvalidValue().toString() : "";
			LOGGER.error(violation.getRootBeanClass() + " - " + violation.getPropertyPath() + " - " + violation.getMessage() + ": " + invalidValue);
		}
	}

}
