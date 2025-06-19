package com.turing.javaee7.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloWorldController {

	@GetMapping
	public String index() {
		
		log.info("HelloWorld controller!");
		return "index";
	}

}
