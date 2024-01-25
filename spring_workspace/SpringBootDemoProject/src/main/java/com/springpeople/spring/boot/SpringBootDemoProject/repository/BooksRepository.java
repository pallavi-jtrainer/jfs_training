package com.springpeople.spring.boot.SpringBootDemoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springpeople.spring.boot.SpringBootDemoProject.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{
	// select * from books where book_id=id
	public Books findByBookId(long id);
	
	//select * from books where price between (min, max)
	public List<Books> findAllByPriceBetween(double min, double max);
	
	public Books findByIsbn(String isbn);
	
	public Books findTopOneByOrderByBookIdDesc();
	
}
