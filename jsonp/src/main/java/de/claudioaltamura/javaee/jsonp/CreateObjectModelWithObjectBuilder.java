package de.claudioaltamura.javaee.jsonp;

import javax.json.Json;
import javax.json.JsonObject;

public class CreateObjectModelWithObjectBuilder {

	public static void main(String[] args) {
		JsonObject model = Json.createObjectBuilder()
				.add("title", "Building Microservices")
				.add("author", "Sam Newman")
				.add("publisher", "O'Reilly")
				.add("pages", 278)
				.add("ISBN", "978-1491950357")
				.add("price", 12.0)
				.add("currency", "EUR")
				.build();
		System.out.println(model);
	}

}
