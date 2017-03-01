package de.claudioaltamura.javaee.jaxrs.helloworld;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldApplicationTest {

	private HttpServer server;

	private String webContextPath = "/hello";

	private WebTarget target;

	@Before
	public void setUp() {
		server = HelloWorldApplication.startServer();
		Client c = ClientBuilder.newClient();
		target = c.target(HelloWorldApplication.BASE_URI);
	}

	@After
	public void tearDown() {
		server.shutdown();
	}

	@Test
	public void test() {
		String txt = target.path(webContextPath + "/test").request(MediaType.TEXT_PLAIN).get(String.class);
		assertEquals("Hello World : test", txt);
	}

}
