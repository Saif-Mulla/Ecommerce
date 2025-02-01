package com.learning.CartService.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemIds;
	

    private int cartId;

    private int productId;

    private int quantity;
    
    public void setCartId(int cartId) {
		this.cartId = cartId;
	}
    
    public int getCartId() {
		return cartId;
	}
    
    public void setCartItemIds(int cartItemIds) {
		this.cartItemIds = cartItemIds;
	}
    
    public int getCartItemIds() {
		return cartItemIds;
	}
    
    public void setProductId(int productId) {
		this.productId = productId;
	}
    
    public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    public int getProductId() {
		return productId;
	}
    
    public int getQuantity() {
		return quantity;
	}
    

}

