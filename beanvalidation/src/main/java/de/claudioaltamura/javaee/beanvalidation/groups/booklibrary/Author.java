package de.claudioaltamura.javaee.beanvalidation.groups.booklibrary;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import de.claudioaltamura.javaee.beanvalidation.booklibrary.Book;

public class Author {

	public interface NameValidation { }
	public interface AgeValidation extends NameValidation { }

	@NotBlank(message = "name not blank", groups = NameValidation.class )
	private String name;

	@NotEmpty
	private List<Book> books;

	@Min(value = 10,  groups = AgeValidation.class )
	private int age;

}
