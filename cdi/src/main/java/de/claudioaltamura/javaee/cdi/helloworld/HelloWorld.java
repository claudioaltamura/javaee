package de.claudioaltamura.javaee.cdi.helloworld;

import javax.inject.Inject;

public class HelloWorld {

	@Inject
	private DatePrinter dateprinter;
	
	public String hello() {
		return "Hello CDI at " + dateprinter;
	}

}