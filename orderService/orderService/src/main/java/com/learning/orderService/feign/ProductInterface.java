package com.learning.orderService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.orderService.model.ProductDTO;


@FeignClient("PRODUCTSERVICE")
public interface ProductInterface {
	
	@GetMapping("/product/{prodId}")
	public ProductDTO getProductById(@PathVariable int prodId);

}

