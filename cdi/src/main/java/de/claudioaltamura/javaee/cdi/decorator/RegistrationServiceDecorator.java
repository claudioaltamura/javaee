package de.claudioaltamura.javaee.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class RegistrationServiceDecorator implements RegistrationService {

	@Inject @Delegate @Any
	private RegistrationService registrationService;
	
	@Override
	public String register(String name) {
		String result = registrationService.register(name);
		return "Decorator: Hello you "+ result + "!";
	}

}
