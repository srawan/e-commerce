package com.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProduceService;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
				
	}
	
	@Bean
	CommandLineRunner runner(ProduceService produceService) {
		
		return (args) ->{
			produceService.save(new Product(new Long(505), "Shoe", 555.44, null));
			produceService.save(new Product(new Long(1000), "Nike", 549.44, null));
		};
		
	}
}
