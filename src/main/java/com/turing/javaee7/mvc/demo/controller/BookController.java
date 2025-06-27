package com.turing.javaee7.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee7.mvc.demo.common.BookValidator;
import com.turing.javaee7.mvc.demo.dto.BookDto;
import com.turing.javaee7.mvc.demo.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//အောက်က နှစ်ခုက  custom validator  အတွက် setup ပါ
	@Autowired
	private BookValidator bookValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(bookValidator);
	}
	
	
	@GetMapping
	String findAllBooks(Model model) {
		
		List<BookDto> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		
		for (BookDto book : books) {
			log.info("Book: {}", book);
		}
		
		return "books/book" ;
	}
	
	
	@GetMapping("/new")
	String newBook(Model model) {
		
		BookDto bookDto=new BookDto();		
		//bookDto.setAuthor(" Dummy Author");
		model.addAttribute("book",bookDto);
				
		return "books/new";
	}
	
	/*
	 * @PostMapping("/new") String saveNewBook(@ModelAttribute("book") @Valid
	 * BookDto book,BindingResult bindingResult) {
	 * 
	 * if (bindingResult.hasErrors()) { log.error("Error in book form: {}",
	 * bindingResult.getAllErrors());
	 * 
	 * } else { log.info("Save book :"+ book); } return "books/new"; }
	 */
	
	@PostMapping("/new")
	String saveNewBook(@ModelAttribute("book") @Validated BookDto book,BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			log.error("Error in book form: {}", bindingResult.getAllErrors());
		
		}
		else {
			log.info("Save book :"+ book);
			this.bookService.saveBook(book);

			return "redirect:/books";
		}
		return "books/new";
	}
	
	
	@GetMapping("/edit/{id}")
	String editBook(Model model,@PathVariable("id") Long id) {
		
		BookDto bookDto=this.bookService.getBookById(id);		
		//bookDto.setAuthor(" Dummy Author");
		model.addAttribute("book",bookDto);
				
		log.info("Edit book with id:", id);
		return "books/new";
	}
	
}
