package com.springpeople.spring.boot.SpringBootDemoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	// delete from books where book_id = id
	public void deleteByBookId(long id);
	
//	@Query("from Books b where b.title = :title")
//	public List<Books> listAllBooksByTitle(@Param("title") String title);
	
	public List<Books> findAllByTitleStartingWith(String title);
	
	@Modifying
	@Query(value = "update books set price = :price where book_id = :id", nativeQuery=true)
	public int updatePrice(@Param("id") long id, @Param("price") double price);
	
}
