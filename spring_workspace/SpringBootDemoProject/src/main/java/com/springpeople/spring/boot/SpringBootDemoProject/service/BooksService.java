package com.springpeople.spring.boot.SpringBootDemoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpeople.spring.boot.SpringBootDemoProject.entity.Books;
import com.springpeople.spring.boot.SpringBootDemoProject.repository.BooksRepository;

import jakarta.transaction.Transactional;

@Service
public class BooksService {
	
	@Autowired
	private BooksRepository repo;
	
	public List<Books> listAllBooks() {
		return repo.findAll();
	}
	
	public Books retrieveBookById(long id) {
		return repo.findByBookId(id);
	}
	
	public Books getByIsbn(String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	public Books createBook(Books b) {
		Books book = repo.findTopOneByOrderByBookIdDesc();
		long id = 1;
		if(book != null) {
			id = book.getBookId() + 1;
		}
		b.setBookId(id);
		return repo.save(b);
	}
	
	public void updateBook(Books book) {
		repo.save(book);
	}
	
	public void deleteBook(long id) {
		repo.delete(retrieveBookById(id));
	}
	
	@Transactional
	public void updatePrice(long id, double price) {
		int res = repo.updatePrice(id, price);
		if(res > 0) {
			System.out.println("Update done");
		} else
			System.out.println("Update not done");
	}
}
