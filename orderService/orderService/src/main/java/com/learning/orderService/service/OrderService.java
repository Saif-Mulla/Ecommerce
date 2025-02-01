package com.learning.orderService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.learning.orderService.feign.CartItemsInterface;
import com.learning.orderService.feign.ProductInterface;
import com.learning.orderService.feign.UserInterface;
import com.learning.orderService.model.CartItemsDTO;
import com.learning.orderService.model.Order;
import com.learning.orderService.model.ProductDTO;
import com.learning.orderService.model.UserDTO;
import com.learning.orderService.repository.OrderRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo; 
	
	@Autowired
	private UserInterface interface1;
	
	@Autowired
	private CartItemsInterface interface2;
	
	@Autowired
	private ProductInterface interface3;
	
	private Order order = null;
		
	public String token = null;
	
	public List<Order> getAllOrders() {
		token = getJwtFromRequest();
		UserDTO user = interface1.getLoggedInUser(token);
		return repo.findAllByUsername(user.getUsername());
	}

	public Order getOrder(int orderId) {
		return repo.findById(orderId).orElse(null);
	}

	public Order checkout(int cartId) {
		token = getJwtFromRequest();
		UserDTO loggedInUser = interface1.getLoggedInUser(token);
		
		List<CartItemsDTO> cartItems = interface2.getCartItemsByCartId(cartId);
		System.out.println(cartItems);
		order = new Order();
		order.setUsername(loggedInUser.getUsername());
		order.setCartId(cartId);
		order.setStatus("ORDERED");
		order.setOrderTotal(calculateTotal(cartItems));
		order.setOrderDate(new Date());
		order.setDeliveryDate(new Date(System.currentTimeMillis() + (3 * 24 * 60 * 60 * 1000)));
		
		repo.save(order);
		
		return order;
	}
	
	private double calculateTotal(List<CartItemsDTO> cartItems) {
		
		double total = 0;
		ProductDTO product;
		
		for (CartItemsDTO cartItemsDTO : cartItems) {
			product = interface3.getProductById(cartItemsDTO.getProductId());
			total += product.getProductPrice() * cartItemsDTO.getQuantity();
		}
		
		return total;
		
	}
	
    private String getJwtFromRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            return request.getHeader(HttpHeaders.AUTHORIZATION);
        }
        return null;
    }
	
}
