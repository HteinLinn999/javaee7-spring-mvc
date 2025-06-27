package com.turing.javaee7.mvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turing.javaee7.mvc.demo.dto.Product;
import com.turing.javaee7.mvc.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<String> getAllProducts() {
		List<String> products = new ArrayList<>();

		products.add("Apple");
		products.add("Banana");
		products.add("Cherry");
		products.add("Date");
		products.add("Elderberry");
		products.add("Fig");

		return products;
	}

	@Override
	public List<Product> getAllProductsWithDetails() {
		List<Product> products = new ArrayList<>();

		
		products.add(new Product("Apple", 10.00));
		products.add(new Product("Banana", 5.00));
		products.add(new Product("Cherry", 15.00));
		products.add(new Product("Date", 20.00));
		products.add(new Product("Elderberry", 25.00));
//		products.add(new Product("Fig", 30.00));
//		products.add(new Product("Grape", 12.00));
//		products.add(new Product("Honeydew", 18.00));
//		products.add(new Product("Kiwi", 8.00));
//		products.add(new Product("Lemon", 6.00));
//		products.add(new Product("Mango", 14.00));
//		products.add(new Product("Nectarine", 22.00));
		
		return products;
	}

}
