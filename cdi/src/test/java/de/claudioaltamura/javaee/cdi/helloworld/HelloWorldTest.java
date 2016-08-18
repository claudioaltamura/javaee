package de.claudioaltamura.javaee.cdi.helloworld;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.claudioaltamura.javaee.cdi.util.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class HelloWorldTest {

	@Inject 
	private HelloWorld helloWorld;
	
	@Test
	public void test() {
		assertTrue(helloWorld.hello().contains("Hello CDI"));
	}

}
