package de.claudioaltamura.javaee.cdi.helloworld;

import de.claudioaltamura.javaee.cdi.util.WeldContext;

public class HelloWorldWeldContextExample {

	public static void main(String[] args) {
		HelloWorld helloWorld = WeldContext.INSTANCE.getBean(HelloWorld.class);
		System.out.println(helloWorld.hello());
	}
	
}
