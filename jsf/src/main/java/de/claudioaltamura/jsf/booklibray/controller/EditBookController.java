package de.claudioaltamura.jsf.booklibray.controller;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.claudioaltamura.jsf.booklibray.data.BookListProducer;
import de.claudioaltamura.jsf.booklibray.data.BookProducer;
import de.claudioaltamura.jsf.booklibray.model.Book;

@SessionScoped
@Named
public class EditBookController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOGGER = Logger.getLogger(EditBookController.class.getName()); 

	private AtomicLong counter = new AtomicLong(0);
	
	@Inject
	private BookListProducer bookListProducer;

	@Inject
	private BookProducer bookProducer;

	public String doSave() {
		Book editedBook = bookProducer.getSelectedBook();
		if(bookProducer.isAddMode()) {
			bookListProducer.getBooks().add(editedBook);
			LOGGER.log(Level.INFO, "new book saved");
		} else {
			LOGGER.log(Level.INFO, "book changed");
		}
		
		return Pages.LIST_BOOKS;
	}
	
	public String doCancel() {
		LOGGER.log(Level.INFO, "doCancel");
		bookProducer.setSelectedBook(null);
		
		return Pages.LIST_BOOKS;
	}
	
	
	public void generateDescription() throws InterruptedException {
		LOGGER.log(Level.INFO, "generate description");
		
		Book editedBook = bookProducer.getSelectedBook();
		
		Thread.sleep(3000);
		
		long cnt = counter.incrementAndGet();
		String generatedDescription = "good book"; 
		if(cnt % 2 == 0) {
			generatedDescription = "very good book";
		}
	
		editedBook.setDescription(editedBook.getDescription() + " - " + generatedDescription);
	}
	

}
