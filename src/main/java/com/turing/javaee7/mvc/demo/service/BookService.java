package com.turing.javaee7.mvc.demo.service;
import java.util.List;
//import java.util.Optional;

import com.turing.javaee7.mvc.demo.dto.BookDto;

public interface BookService {

	List<BookDto> getAllBooks();
	void saveBook(BookDto book);
	//Optional<BookDto> getBookById(Long id);
	BookDto getBookById(Long id);
}
