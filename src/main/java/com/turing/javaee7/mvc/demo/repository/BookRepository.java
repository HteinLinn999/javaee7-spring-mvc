package com.turing.javaee7.mvc.demo.repository;

import java.util.List;

import com.turing.javaee7.mvc.demo.model.Book;

public interface BookRepository {

	List<Book> getAllBooks();
	void saveBook(Book book);
	Book getBookById(Long id);
}
