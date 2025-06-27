package com.turing.javaee7.mvc.demo.dto;

public record Product(String name, double price) {
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
}
