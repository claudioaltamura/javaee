package de.claudioaltamura.javaee.cdi.weldjunit;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;
import org.junit.Test;

import de.claudioaltamura.javaee.cdi.Greeter;

public class GreeterWeldJUnitTest {

	@Rule
	public WeldInitiator weld = WeldInitiator.from(Greeter.class).inject(this).build();

	@Inject
	Greeter greeter;

	@Test
	public void test() {
		assertEquals("Hello, you!", greeter.createGreeting("you"));
	}

}
