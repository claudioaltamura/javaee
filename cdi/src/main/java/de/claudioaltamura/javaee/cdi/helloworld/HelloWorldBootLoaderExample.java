package de.claudioaltamura.javaee.cdi.helloworld;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

public class HelloWorldBootLoaderExample {
	
	@Inject
	private HelloWorld helloWorld;

	public void bootListener(@Observes ContainerInitialized event, @Parameters List<String> cmdLineArgs) {
		//System.out.println(helloWorld.hello());
	}	
	
}
