package de.claudioaltamura.javaee.jaxrs.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldResource {

	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Hello World : " + msg;

		return Response.status(200).entity(output).build();
	}

}
