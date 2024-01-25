package com.springpeople.spring.boot.SpringBootDemoProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	@Id
	@Column(name="book_id")
	private long bookId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="price")
	private double price;
	
	public Books() {
		
	}
	
	public Books(String title, String isbn, double price, long bookId) {
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", price=" + price + "]";
	}
	
	
}
