package com.turing.javaee7.mvc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.turing.javaee7.mvc.demo.dto.Product;
import com.turing.javaee7.mvc.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mvc")
public class MVCController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public String mvc(Model model) {

		model.addAttribute("message", "Message From MVC");
		log.info(" MVCController!");
		return "index";
	}

	@GetMapping("/admin")
	public String admin(Model model) {

		model.addAttribute("admin", true);
		log.info(" MVCController admin!");
		return "index";
	}

	@GetMapping("/list")
	public String productList(Model model) {

		List<String> products = productService.getAllProducts();

		model.addAttribute("products", products);
		log.info(" get all products!");
		return "list";
	}

	/*
	 * @GetMapping("/products") public String productDetailList(Model model) {
	 * 
	 * List<Product> products = productService.getAllProductsWithDetails();
	 * 
	 * model.addAttribute("productsWithDetails", products);
	 * log.info(" get all products with Details!"); return "product"; }
	 */

	
	@GetMapping("/products")
	public String requestParameter(Model model,@RequestParam("productId") String productId) {

		log.info("product with product id :"+productId);

		model.addAttribute("productsWithDetails", this.productService.getAllProductsWithDetails());
		log.info(" get all products with Details!");
		return "product";
	}

}
