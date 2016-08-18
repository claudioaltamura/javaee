package de.claudioaltamura.javaee.cdi.events;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class EventsExample {

	public static void main(String[] args) {
		Weld weld = new Weld();
		weld.disableDiscovery();
		weld.addPackages(true, PersonService.class);
		WeldContainer container = weld.initialize();
		PersonService personService = container.instance().select(PersonService.class).get();
		Person person = personService.create();
		person.setName("Me2");
		personService.update(person);
		weld.shutdown();
	}
}
