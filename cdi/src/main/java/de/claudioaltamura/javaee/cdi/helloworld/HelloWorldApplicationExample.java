package de.claudioaltamura.javaee.cdi.helloworld;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class HelloWorldApplicationExample {

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		HelloWorld helloWorld = container.instance().select(HelloWorld.class).get();
		System.out.println(helloWorld.hello());
		weld.shutdown();
	}

}
