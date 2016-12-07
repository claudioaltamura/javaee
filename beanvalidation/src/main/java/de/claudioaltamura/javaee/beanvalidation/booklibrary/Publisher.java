package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Publisher implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@NotNull
	private List<Book> books;

	@NotNull
	private List<Author> authors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
