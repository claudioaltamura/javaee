package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Author {

    @NotBlank(message = "name not blank")
	private String name;

    @NotEmpty
    @Valid
    private List<Book> books;

    @Email
    private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", books=" + books + ", email=" + email + "]";
	}

}
