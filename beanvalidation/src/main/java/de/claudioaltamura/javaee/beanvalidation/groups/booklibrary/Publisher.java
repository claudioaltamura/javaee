package de.claudioaltamura.javaee.beanvalidation.groups.booklibrary;

import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Publisher {

	public interface NameValidation {};

	public interface AuthorValidation {};

	@GroupSequence({NameValidation.class, AuthorValidation.class})
	public interface PublisherValidation {};

	@NotEmpty(groups = AuthorValidation.class)
	private List<Author> authors;

	@NotEmpty(groups = NameValidation.class)
	private String name;

	@NotNull
	private List<String> books;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [authors=" + authors + ", name=" + name + ", books=" + books + "]";
	}

}
