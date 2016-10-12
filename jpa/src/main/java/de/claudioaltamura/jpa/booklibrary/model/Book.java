package de.claudioaltamura.jpa.booklibrary.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name=Book.findAll,query="SELECT b FROM book b ORDER BY b.title"),
	@NamedQuery(name=Book.findByTitle,query="SELECT b FROM book b WHERE b.title = :title"),
})
@Entity
public class Book {

	public static final String findAll ="Book.findAll";
	public static final String findByTitle ="Book.findByTitle";
	
	private Date date;
	private String title;
	private int pages;
	private String isbn;
	private BigDecimal price = new BigDecimal(0.0);
	private String description = "";

	@GeneratedValue
	@Id
	private Long id;
	
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
	
}
