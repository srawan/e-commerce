package com.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProduceService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProduceService produceService;
	
	@GetMapping(value = {"", "/"})
	public @NotNull Iterable<Product> getProduct() {
		return produceService.getAllProducts();
	}
	

}
