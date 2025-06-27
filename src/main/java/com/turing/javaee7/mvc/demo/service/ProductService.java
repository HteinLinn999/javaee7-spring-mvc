package com.turing.javaee7.mvc.demo.service;

import java.util.List;

import com.turing.javaee7.mvc.demo.dto.Product;

public interface ProductService {
	List<String> getAllProducts();
	List<Product> getAllProductsWithDetails();
}
