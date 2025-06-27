package com.turing.javaee7.mvc.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.turing.javaee7.mvc.demo.model.Book;
import com.turing.javaee7.mvc.demo.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {

	List<Book> books = new ArrayList<>();

	Long nextId = 4L;

	public BookRepositoryImpl() {
		books.add(new Book(1L, "Effective Java", "Joshua Bloch", "A com" + "prehensive guide to programming in Java.",
				12L));
		books.add(new Book(2L, "Clean Code", "Robert C. Martin", "A handbook of agile software craftsmanship.", 34L));
		books.add(new Book(3L, "Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
				"Elements of reusable object-oriented software.", 21L));
	}

	@Override
	public List<Book> getAllBooks() {

		return books;
	}

	@Override
	public void saveBook(Book book) {

		book.setId(nextId++);
		this.books.add(book);
	}

	@Override
	public Book getBookById(Long id) {
		
		Book book =null;
		
		for (Book b : books) {
			if (b.getId().equals(id)) {
				//book = b;
				//break;
				return b;
			}
		}
		
		return book;
	}

}
