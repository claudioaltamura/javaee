package de.claudioaltamura.jpa.booklibrary.services;

import java.util.List;

import de.claudioaltamura.jpa.booklibrary.model.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBook(Long id);

	Book add(Book book);

	Book update(Book book);
	
	void delete(Book book);

	void delete(Long d);

}
