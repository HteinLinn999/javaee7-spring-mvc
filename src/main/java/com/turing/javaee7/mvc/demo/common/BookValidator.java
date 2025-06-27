package com.turing.javaee7.mvc.demo.common;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.turing.javaee7.mvc.demo.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BookValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return BookDto.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		log.info("BookValidator  validate");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.book.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required.book.author");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.book.description");
		BookDto bookDto = (BookDto) obj;

		String title = bookDto.getTitle();

		// Only validate first character if title exists and has no errors
		if (title != null && !title.trim().isEmpty() && !errors.hasFieldErrors("title")) {
			char firstChar = title.charAt(0);
			if (!Character.isUpperCase(firstChar)) {
				errors.rejectValue("title", "uppercase.book.title");
			}
		}

	}

}
