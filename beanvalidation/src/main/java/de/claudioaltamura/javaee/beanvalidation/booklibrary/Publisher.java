package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Publisher {

	@NotNull
	private String name;

	@NotNull
	@Valid
	private List<Book> books;

	@NotNull
	@Valid
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

	@Override
	public String toString() {
		return "Publisher [name=" + name + ", books=" + books + ", authors=" + authors + "]";
	}

}