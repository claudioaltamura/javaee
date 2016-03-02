package de.claudioaltamura.javaee.jsonp;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import org.apache.commons.io.IOUtils;

public class CreateObjectModelFromFile {

	public static void main(String[] args) throws FileNotFoundException {
		CreateObjectModelFromFile comff = new CreateObjectModelFromFile();
		String fileName = "book.json";
		comff.read(fileName);
	}
	
	private void read(String fileName) {
		InputStream is = getClass().getResourceAsStream(fileName);
		try(JsonReader reader = Json.createReader(is))
		{
			JsonStructure jsonStructure = reader.read();
			System.out.println(jsonStructure);
		} catch(JsonException je)
		{
			je.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}
