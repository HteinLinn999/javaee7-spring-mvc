package com.turing.javaee7.mvc.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
	private Long id;
	private String title;
	private String author;
	private String description;
	private Long price;
}
