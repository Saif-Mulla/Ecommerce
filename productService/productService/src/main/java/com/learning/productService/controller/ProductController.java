package com.learning.productService.controller;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.productService.model.Product;
import com.learning.productService.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service; 
	
	@RequestMapping("/showProducts")
	public ResponseEntity<List<Product>> getProducts(HttpSession http){
		System.out.println(http.getId());
		return new ResponseEntity<List<Product>>(service.getAllProducts(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{prodId}")
	public ResponseEntity<Product> getProductById(@PathVariable int prodId){
		if(service.getProductById(prodId) != null) {
			return new ResponseEntity<>(service.getProductById(prodId), HttpStatus.OK);
		}else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public void addProduct(@RequestBody Product product ){
		service.addProduct(product);
		
	}
	
	@PutMapping("/add")
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	
	@DeleteMapping("/{prodId}")
	public String deleteProduct(@PathVariable int prodId) {
		return service.deleteProduct(prodId);
	}
	
	@GetMapping("/search/")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword) {
		if(!service.searchProduct(keyword).isEmpty())
			return new ResponseEntity<List<Product>>(service.searchProduct(keyword),HttpStatus.FOUND);
		else
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		
	}
	
}
