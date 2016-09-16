package de.claudioaltamura.javaee.cdi.decorator;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.claudioaltamura.javaee.cdi.util.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class DecoratorTest {

	@Inject 
	private RegistrationService registrationService;
	
	@Test
	public void test() {
		String param = "Otto";
		assertTrue(registrationService.register(param).contains("Decorator"));
	}
}
