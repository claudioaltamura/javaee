package de.claudioaltamura.jsf.booklibray.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.claudioaltamura.jsf.booklibray.data.BookProducer;
import de.claudioaltamura.jsf.booklibray.model.Book;

@SessionScoped
@Named
public class ListBookController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookProducer bookProducer;
	
	@SuppressWarnings("unused")
	private Book book;
	
	public String doListBooks() {
		return Pages.LIST_BOOKS;
	}
	
	public String doAddBook() {
		bookProducer.prepareAddBook();
		return Pages.EDIT_BOOK;
	}

    public String doEditBook(Book book) {
        bookProducer.prepareEditBook(book);
        return Pages.EDIT_BOOK;
    }

    public void doDeleteBook(Book book) {
        this.book = book;
        System.out.println("Book marked as deleted");
    }

    public void commitDeleteBook() {
        System.out.println("Book deleted");
    }

}