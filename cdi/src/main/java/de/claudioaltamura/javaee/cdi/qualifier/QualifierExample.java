package de.claudioaltamura.javaee.cdi.qualifier;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class QualifierExample {

	public static void main(String[] args) {
		Weld weld = new Weld();
		weld.disableDiscovery();
		weld.addPackages(true, Service.class);
		WeldContainer container = weld.initialize();
		
		Client client = container.select(Client.class).get();
		System.out.println(client.getServiceA());
		System.out.println(client.getServiceB());

		weld.shutdown();		
	}
	

}
