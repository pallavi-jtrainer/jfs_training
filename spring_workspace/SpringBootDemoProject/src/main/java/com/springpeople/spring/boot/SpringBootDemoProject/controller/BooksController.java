package com.springpeople.spring.boot.SpringBootDemoProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springpeople.spring.boot.SpringBootDemoProject.entity.Books;
import com.springpeople.spring.boot.SpringBootDemoProject.service.BooksService;

@Controller
@RequestMapping("/books/")
public class BooksController {

	@Autowired
	private BooksService service;
	
//	@GetMapping
//	public List<Books> listAllBooks() {
//		return service.listAllBooks();
//	}

	@GetMapping("list")
	public String showAllBooks(Model model) {
		model.addAttribute("books", service.listAllBooks());
		return "index";
	}
	
	@GetMapping("title")
	public String showAllBooksByTitle(Model model, @RequestParam String name) {
		model.addAttribute("books", service.listAllByTitle(name));
		return "index";
	}
	
	@GetMapping("upload")
	public String showAddBook(Books book) {
		return "add-book";
	}
	
	@PostMapping("add")
	public String postBookDetails(@ModelAttribute Books book, Model model) {
		service.createBook(book);
		return "redirect:list";
	}
	
	@GetMapping("edit")
    public String getUpdatePage(Model model, @RequestParam Long id) {
       String page = null; 
       Books book = service.retrieveBookById(id);
       model.addAttribute("book", book);
       page="updatebook";
       return page; 
    }
	
	@PostMapping("/update")
    public String updateBook(@ModelAttribute Books book) {
      // service.updateBook(book);
		service.updatePrice(book.getBookId(), book.getPrice());
       return "redirect:list";
    }
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam Long id) {
		service.deleteBook(id);
		return "redirect:list";
	}
	
}
