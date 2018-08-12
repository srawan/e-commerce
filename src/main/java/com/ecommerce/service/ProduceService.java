package com.ecommerce.service;

import com.ecommerce.model.Product;

public interface ProduceService {
	
	public Iterable<Product> getAllProducts();
	public Product getProductById(long id);
	
	public Product save(Product product);

}
