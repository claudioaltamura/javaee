package de.claudioaltamura.javaee.jsonp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.stream.JsonGenerator;

public class WritingWithStreamingJsonGenerator {

	public static void main(String[] args) {
		WritingWithStreamingJsonGenerator wwsjg = new WritingWithStreamingJsonGenerator();
		String fileName = "test.txt";
		wwsjg.write(fileName);
		
		String jsonReaded = wwsjg.read(fileName);
		System.out.println(jsonReaded);
	}

	private void write(String fileName) {
		try(FileWriter writer = new FileWriter(fileName))
		{
			generate(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generate(FileWriter writer) {
		try(JsonGenerator generator = Json.createGenerator(writer))
		{
			generator.writeStartObject()
					.write("title", "Building Microservices")
					.write("author", "Sam Newman")
					.write("publisher", "O'Reilly")
					.write("pages", 278)
					.write("ISBN", "978-1491950357")
					.write("price", 12.0)
					.write("currency", "EUR")
					.writeEnd();
		}
	}
	
	private String read(String fileName) {
		String json = "";
		try (FileReader fileReader = new FileReader(fileName))
		{
			try(JsonReader reader = Json.createReader(fileReader))
			{
				JsonStructure read = reader.read();
				json = read.toString();
			} catch(JsonException je)
			{
				je.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}

}