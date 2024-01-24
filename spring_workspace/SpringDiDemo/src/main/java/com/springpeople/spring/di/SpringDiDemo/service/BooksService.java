package com.springpeople.spring.di.SpringDiDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpeople.spring.di.SpringDiDemo.model.Books;

@Service 
public class BooksService {
//	@Autowired
	private Books book;

//	@Autowired
	public BooksService(Books book) {
		this.book = book;
	}
	
	@Autowired
	public void setBook(Books book) {
		this.book = book;
	}
	
//	public Books getBook() {
//		return book;
//	}
	
	public Books addBookInfo() {
		return this.book;
	}
	
	public void showBookDetails() {
		System.out.println(book.toString());
	}
}
