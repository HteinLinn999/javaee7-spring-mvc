package com.turing.javaee7.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MVCController {

	@GetMapping("/mvc")
	public String mvc(Model model) {
		
		model.addAttribute("message","Message From MVC");
		log.info(" MVCController!");
		return "index";
	}

}
