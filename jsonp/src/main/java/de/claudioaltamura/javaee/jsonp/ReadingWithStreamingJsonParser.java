package de.claudioaltamura.javaee.jsonp;

import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.stream.JsonParser;

import org.apache.commons.io.IOUtils;

public class ReadingWithStreamingJsonParser {

	public static void main(String[] args) {
		ReadingWithStreamingJsonParser rwsjp = new ReadingWithStreamingJsonParser();
		rwsjp.read();
	}

	private void read() {
		String fileName = "book.json";

		InputStream is = getClass().getResourceAsStream(fileName);
		try	{
			parse(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	private void parse(InputStream is) {
		try(JsonParser parser = Json.createParser(is))
		{
			while (parser.hasNext()) {
			   JsonParser.Event event = parser.next();
			   switch(event) {
			      case START_ARRAY:
			      case END_ARRAY:
			      case START_OBJECT:
			      case END_OBJECT:		   
	
			      case VALUE_FALSE:
			      case VALUE_NULL:
			      case VALUE_TRUE:
			         System.out.println(event.toString());
			         break;
			      case KEY_NAME:
			         System.out.print(event.toString() + " " +
			                          parser.getString() + " - ");
			         break;
			      case VALUE_STRING:
			      case VALUE_NUMBER:
			         System.out.println(event.toString() + " " +
			                            parser.getString());
			         break;
			   }
			}
		} catch(JsonException je)
		{
			je.printStackTrace();
		}
	}

}
