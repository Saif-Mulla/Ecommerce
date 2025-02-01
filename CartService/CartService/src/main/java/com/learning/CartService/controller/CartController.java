package com.learning.CartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.CartService.model.Cart;
import com.learning.CartService.model.CartItems;
import com.learning.CartService.service.CartItemsService;

@RestController
public class CartController {

	@Autowired
	private CartItemsService cartItemsService;
	
	@PostMapping("/addToCart/{productId}/{quantity}")
	private ResponseEntity<CartItems> addToCart(@PathVariable int productId, @PathVariable int quantity) {
		return new ResponseEntity<CartItems>(cartItemsService.addToCart(productId,quantity), HttpStatus.CREATED);
	}
	
	@GetMapping("/getCart/{cartId}")
	public List<CartItems> getCartItemsByCartId(@PathVariable int cartId) {
		return cartItemsService.getCartItemsByCartId(cartId);
	}
	
}
