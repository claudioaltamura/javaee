package de.claudioaltamura.javaee.beanvalidation.custom.crossparameter;

import static de.claudioaltamura.javaee.beanvalidation.BeanvalidationTestUtils.logViolations;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.time.ZonedDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;

import org.junit.Before;
import org.junit.Test;

public class ConsistentDateParametersTest {

	private static ExecutableValidator executableValidator;
	private ZonedDateTime start;
	private ZonedDateTime end;

	@Before
	public void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		executableValidator = factory.getValidator().forExecutables();

		start = ZonedDateTime.parse("2017-01-01T00:00:00+01:00[Europe/Paris]");
		end = ZonedDateTime.parse("2017-01-31T23:59:59+01:00[Europe/Paris]");
	}

	@Test
	public void testIsNotValid() throws NoSuchMethodException, SecurityException {
		PromotionCampaign campaign = new PromotionCampaign(end, start);
		Constructor<? extends PromotionCampaign> constructor = campaign.getClass().getConstructor(ZonedDateTime.class, ZonedDateTime.class);

		Object[] parameterValues = new Object[] {end, start};
		Set<ConstraintViolation<PromotionCampaign>> constraintViolations =
				executableValidator.validateConstructorParameters(constructor, parameterValues, Default.class);
		logViolations(constraintViolations);

		assertEquals( 1, constraintViolations.size() );
		assertEquals("start date must before end date", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void testIsValid() throws NoSuchMethodException, SecurityException {
		PromotionCampaign campaign = new PromotionCampaign(start, end);
		Constructor<? extends PromotionCampaign> constructor = campaign.getClass().getConstructor(ZonedDateTime.class, ZonedDateTime.class);

		Object[] parameterValues = new Object[] {start, end};
		Set<ConstraintViolation<PromotionCampaign>> constraintViolations =
				executableValidator.validateConstructorParameters(constructor, parameterValues, Default.class);

		assertEquals( 0, constraintViolations.size() );
	}

}
