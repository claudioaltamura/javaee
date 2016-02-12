package de.claudioaltamura.jsf.booklibray.data;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.claudioaltamura.jsf.booklibray.model.Book;

@SessionScoped
@Named
public class BookProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	private enum Mode {
        EDIT, ADD
    }

    private Book book;
    private Mode mode;

    public Book getSelectedBook() {
        return book;
    }

    public void setSelectedBook(Book book) {
        this.book = book;
    }

    public boolean isAddMode() {
        return mode == Mode.ADD;
    }

    public void prepareAddBook() {
        this.book = new Book();
        this.mode = Mode.ADD;
    }

    public void prepareEditBook(Book book) {
        this.book = book;
        this.mode = Mode.EDIT;
    }

}
