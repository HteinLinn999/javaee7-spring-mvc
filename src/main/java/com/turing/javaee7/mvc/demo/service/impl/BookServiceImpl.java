package com.turing.javaee7.mvc.demo.service.impl;

import java.util.List;

import com.turing.javaee7.mvc.demo.common.Mapper;
import com.turing.javaee7.mvc.demo.dto.BookDto;
import com.turing.javaee7.mvc.demo.model.Book;
import com.turing.javaee7.mvc.demo.repository.BookRepository;
import com.turing.javaee7.mvc.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	Mapper mapper;

	@Override
	public List<BookDto> getAllBooks() {

		List<Book> books = this.bookRepository.getAllBooks();

		/*
		List<BookDto> bookDtos = books.stream()
				.map(book -> new BookDto(book.getTitle(), 
						book.getAuthor(), book.getDescription())).toList();

		return bookDtos;
		*/
		return mapper.mapList(books, BookDto.class);
	}

	
	public void saveBook(BookDto bookDto 	) {
		Book book= this.mapper.map(bookDto, Book.class);
	    this.bookRepository.saveBook(book);
	}


	@Override
	public BookDto getBookById(Long id) {
		
		Book book= this.bookRepository.getBookById(id);
		return this.mapper.map(book, BookDto.class);
	
	}

}
