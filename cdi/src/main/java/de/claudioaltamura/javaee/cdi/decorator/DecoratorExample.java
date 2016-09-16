package de.claudioaltamura.javaee.cdi.decorator;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class DecoratorExample {

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		RegistrationService service = container.select(RegistrationService.class).get();
		System.out.println(service.register("Otto"));
		
		weld.shutdown();	
	}

}
