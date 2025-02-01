package com.learning.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.orderService.model.Order;
import com.learning.orderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getOrders(){
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(),HttpStatus.FOUND); 
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable int orderId) {
		return new ResponseEntity<Order>(orderService.getOrder(orderId),HttpStatus.FOUND);
	}

	@PostMapping("/checkout/{cartId}")
	public ResponseEntity<Order> checkout(@PathVariable int cartId) {
		return new ResponseEntity<Order>(orderService.checkout(cartId), HttpStatus.CREATED);
	}
	
}
