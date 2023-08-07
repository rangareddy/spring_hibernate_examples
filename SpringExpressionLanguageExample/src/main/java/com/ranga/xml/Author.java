package com.ranga.xml;

import com.ranga.xml.Book;

public class Author {
	private String name;
    private Book book;
    private String bookTitle;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", book=" + book + ", bookTitle="
				+ bookTitle + "]";
	}
}