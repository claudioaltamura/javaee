package de.claudioaltamura.jsf.booklibray.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import de.claudioaltamura.jsf.booklibray.model.Author;
import de.claudioaltamura.jsf.booklibray.model.Book;
import de.claudioaltamura.jsf.booklibray.model.Publisher;

@SessionScoped
@Named
public class BookListProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Book> books;
	
	public BookListProducer() {
		books = createBooks();
	}

	public List<Book> getBooks() {
		return books;
	}

	private List<Book> createBooks() {
		Author newMan = new Author();
		newMan.setName("Sam Newman");
		
		Publisher oreilly = new Publisher();
		oreilly.setName("O'Reilly");
		
		Book buildingMicroservices = new Book();
		buildingMicroservices.setAuthor(newMan);
		buildingMicroservices.setPublisher(oreilly);
		buildingMicroservices.setIsbn("978-1491950357");
		buildingMicroservices.setPages(278);
		buildingMicroservices.setTitle("Building Microservices");
		
		List<Book> books = new ArrayList<>();
		books.add(buildingMicroservices);
		
		return books;
	}
	
}