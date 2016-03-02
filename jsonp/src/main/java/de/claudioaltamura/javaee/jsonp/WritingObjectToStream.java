package de.claudioaltamura.javaee.jsonp;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class WritingObjectToStream {

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
		
		StringWriter stringWriter = new StringWriter();
		writeModel(stringWriter, model);
		String jsonData = stringWriter.toString();
		System.out.println(jsonData);
	}

	private static void writeModel(StringWriter stringWriter, JsonObject model) {
		try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
		   jsonWriter.writeObject(model);
		} catch(JsonException je)
		{
			je.printStackTrace();
		}
	}
}
