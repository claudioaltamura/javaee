package de.claudioaltamura.javaee.cdi.events;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import de.claudioaltamura.javaee.cdi.events.annotations.New;
import de.claudioaltamura.javaee.cdi.events.annotations.Updated;

public class PersonService {
	
	@Inject @Any
	private Event<Person> anyPersonEvent;
	
	@Inject @New
	private Event<Person> newPersonEvent;

	@Inject @Updated
	private Event<Person> updatedPersonEvent;

	public Person create() {
		Person person = new Person();
		person.setName("none");
		anyPersonEvent.fire(person);
		newPersonEvent.fire(person);
		return person;
	}

	public void update(Person personToBeUpdated){
		anyPersonEvent.fire(personToBeUpdated);
		updatedPersonEvent.fire(personToBeUpdated);
	}
}
