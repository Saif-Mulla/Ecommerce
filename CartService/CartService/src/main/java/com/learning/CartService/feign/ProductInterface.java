package com.learning.CartService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.CartService.dto.ProductDto;

@FeignClient("PRODUCTSERVICE")
public interface ProductInterface {
	@GetMapping("/product/{prodId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int prodId);

}
