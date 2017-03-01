package de.claudioaltamura.javaee.jaxrs.template;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.Test;

public class JAXRSTemplatesTest {

	private Client client;
	private WebTarget webTarget;

	@Before
	public void initClient() {
		this.client = ClientBuilder.newClient();
		this.webTarget = this.client.target("https://en.wikipedia.org/wiki/{keyword}");
	}

	@Test
	public void contentContainsKeyword() {
		String keyword = "Java";
		String content = this.webTarget.resolveTemplate("keyword", keyword).request().get(String.class);
		assertTrue(content.contains(keyword));
	}

}
