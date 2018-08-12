package com.ecommerce.serviceImp;

import com.ecommerce.customException.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProduceService;

public class ProductServiceImp implements ProduceService{
	
	ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not found"));
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

}
