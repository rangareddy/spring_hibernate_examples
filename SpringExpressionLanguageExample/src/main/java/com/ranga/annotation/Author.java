package com.ranga.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myAuthorBean")
public class Author {
	
	@Value("Ranga Reddy")
	private String name;
	
	@Value("#{myBookBean}")
    private Book book;
    
    @Value("#{myBookBean.title}")
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
