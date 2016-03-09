package de.claudioaltamura.jsf.booklibray.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.claudioaltamura.jsf.booklibray.model.Author;
import de.claudioaltamura.jsf.booklibray.model.Book;
import de.claudioaltamura.jsf.booklibray.model.Publisher;

@SessionScoped
@Named
public class BookListProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOGGER = Logger.getLogger(BookListProducer.class.getName()); 

	private List<Book> books;
	
	public BookListProducer() {
		init();
	}

	@PostConstruct
    public void init() {
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
		buildingMicroservices.setPrice(BigDecimal.valueOf(12.00));
		
		Author matthias = new Author();
		matthias.setName("Karl Matthias");
		
		Book docker = new Book();
		docker.setAuthor(matthias);
		docker.setPublisher(oreilly);
		docker.setIsbn("978-1491917572");
		docker.setPages(224);
		docker.setTitle("Docker - Up and Running");
		docker.setPrice(BigDecimal.valueOf(10.00));

		List<Book> books = new ArrayList<>();
		books.add(buildingMicroservices);
		books.add(docker);		
		
		return books;
	}

	public void removeBook(Book book) {
		books.remove(book);
		LOGGER.log(Level.INFO, "Book marked as deleted");
	}
	
}