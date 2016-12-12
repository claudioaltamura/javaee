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
			LOGGER.error(violation.getRootBean().getClass().getSimpleName() + " - " + violation.getPropertyPath() + " - " + violation.getMessage() + ": " + violation.getInvalidValue());
		}
	}


}
