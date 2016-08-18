package de.claudioaltamura.javaee.cdi.events;

import javax.enterprise.event.Observes;

import de.claudioaltamura.javaee.cdi.events.annotations.New;
import de.claudioaltamura.javaee.cdi.events.annotations.Updated;

public class Client {
	
	public void onAnyEvent(@Observes Person person) {
		String action = "any Event: person";
		System.out.println(action);
	}
	
	public void onNewEvent(@Observes @New Person person) {
		String action = "new person Event: " + person;
		System.out.println(action);
	}
	
	public void onUpdatedEvent(@Observes @Updated Person person) {
		String action = "updated person Event: " + person;
		System.out.println(action);
	}
	
}
