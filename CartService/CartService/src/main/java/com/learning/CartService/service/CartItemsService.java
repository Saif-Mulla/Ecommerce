package com.learning.CartService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.http.HttpHeaders;

import com.learning.CartService.dto.UserDto;
import com.learning.CartService.feign.ProductInterface;
import com.learning.CartService.feign.UserInterface;
import com.learning.CartService.model.Cart;
import com.learning.CartService.model.CartItems;
import com.learning.CartService.repository.CartItemsRepository;
import com.learning.CartService.repository.CartRepository;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CartItemsService {

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private UserInterface interface1;
	
	@Autowired
	private ProductInterface interface2;
	
	private Cart cart = null;
	private CartItems cartItems = null;
	
	public CartItems addToCart(int productId, int quantity) {
		
		if(validProductId(productId)) {
			
		    String token = getJwtFromRequest();
			
		    UserDto loggedInUser = interface1.getLoggedInUser(token);
		
			Optional<Cart> existingCart = cartRepo.findByUsername(loggedInUser.getUsername());
			
			if(!existingCart.isEmpty()) {
				cart = existingCart.get();
			}else {
				cart = new Cart();
				cart.setUsername(loggedInUser.getUsername());
				cart.setCartStatus(true);
				cart = cartRepo.save(cart);	
			}
			
			cartItems = new CartItems();
			cartItems.setCartId(cart.getCartId());
			cartItems.setProductId(productId);
			cartItems.setQuantity(quantity);
			return cartItemsRepository.save(cartItems);

		}
		return null;
	}
	
    private String getJwtFromRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            return request.getHeader(HttpHeaders.AUTHORIZATION);
        }
        return null;
    }
    
    private boolean validProductId(int prodId) {
        try {
            return interface2.getProductById(prodId) != null;
        } catch (FeignException.NotFound e) {
            return false; // Return false if product is not found (404)
        }
    }

	public List<CartItems> getCartItemsByCartId(int cartId) {
		return cartItemsRepository.findByCartId(cartId);
	}
	
}
