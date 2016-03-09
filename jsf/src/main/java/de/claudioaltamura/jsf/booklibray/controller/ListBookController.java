package de.claudioaltamura.jsf.booklibray.controller;

import java.io.Serializable;
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
public class ListBookController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOGGER = Logger.getLogger(ListBookController.class.getName()); 

	@Inject
	private BookListProducer bookListProducer;
	
	@Inject
	private BookProducer bookProducer;
	
	@SuppressWarnings("unused")
	private Book book;
	
	public String doListBooks() {
		return Pages.LIST_BOOKS;
	}
	
	public String doAddBook() {
		bookProducer.prepareAddBook();
		LOGGER.log(Level.INFO, "preparing for adding a book");
		return Pages.EDIT_BOOK;
	}

    public String doEditBook(Book book) {
        bookProducer.prepareEditBook(book);
		LOGGER.log(Level.INFO, "preparing for editing a book");
        return Pages.EDIT_BOOK;
    }

    public void doDeleteBook(Book book) {
        this.book = book;
        bookListProducer.removeBook(book);
    }

}