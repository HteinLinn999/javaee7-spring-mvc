package com.turing.javaee7.mvc.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/*
 * public record BookDto(String title, String author, String description ) {
 * 
 * public BookDto() { this("", "", ""); } }
 */

@ToString
@Data
public class BookDto {

	Long id;
	
	@NotNull
	@Size(min = 5, max = 100, message = "{size.book.title}")
	@NotEmpty(message = "{required.book.title}")
	private String title;
	
	@NotNull
	@NotEmpty(message = "{required.book.author}")
	private String author;
	  
	
	@NotNull
	@NotEmpty(message = "{required.book.description}")	
	private String description;
	
		
	@NotNull(message = "{required.book.price}")
    @Min(value = 1, message = "{length.book.price}")
	private Long price;

}
