package com.learning.orderService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.orderService.model.CartItemsDTO;


@FeignClient("CARTSERVICE")
public interface CartItemsInterface {
	
	@GetMapping("/getCart/{cartId}")
	public List<CartItemsDTO> getCartItemsByCartId(@PathVariable int cartId);

}
