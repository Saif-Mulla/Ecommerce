package com.learning.productService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.productService.model.Product;
import com.learning.productService.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	Product prod;
	
//	private List<Product> products = new ArrayList<>(Arrays.asList(
//			
//			new Product(101,"Iphone",95000),
//			new Product(102,"Laptop",75000)			
//			));
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int prodId) {
//		Optional<Product> optionalProd = repository.findById(prodId);
//		
//		prod = optionalProd.get();
//		if(prod != null)
//			return prod;
//		else
			return repository.findById(prodId).orElse(null);
//		return products.stream()
//				.filter(p -> p.getProductId() == prodId)
//				.findFirst().get();
				
	}

	public void addProduct(Product product) {
		repository.save(product);
	}

	public void updateProduct(Product product) {
//		products.stream()
//			.map(p -> {
//				
//				if (p.getProductId() == product.getProductId()) {
//					p.setProductId(product.getProductId());
//					p.setProductName(product.getProductName());
//					p.setProductPrice(product.getProductPrice());
//				}
//				return p;
//			}).collect(Collectors.toList()); 
		
		repository.save(product);
	
	}
	
	public String deleteProduct(int prodId) {
		
		Optional<Product> optionProd = repository.findById(prodId);
		
		prod = optionProd.get();
		String name = prod.getProductName();
		repository.delete(prod);
		
		return name;
		
	}

	public List<Product> searchProduct(String keyword) {
		return repository.findByKeyword(keyword) ;
	}
	
}

