package de.claudioaltamura.javaee.beanvalidation.booklibrary;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class Book {

	@Past
	//@Future
	private Date date;

	//@NotBlank
	private String title;

	@Min(value = 1, message="{book.pages}")
	@Max(value = 10000)
	private int pages;

	@Pattern(regexp="(?=.{13}$)\\d{1,5}([- ])\\d{1,7}\\1\\d{1,6}\\1(\\d|X)")
	private String isbn;

	private Author author = new Author();

	private Publisher publisher = new Publisher();

	@DecimalMin("0.00")
	@DecimalMax("1000000.00")
	//@Digits(integer=,fraction=)
	private BigDecimal price;

	//@NotBlank
	private String description;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [date=" + date + ", title=" + title + ", pages=" + pages + ", isbn=" + isbn + ", author=" + author
				+ ", publisher=" + publisher + ", price=" + price + ", description=" + description + "]";
	}

}
