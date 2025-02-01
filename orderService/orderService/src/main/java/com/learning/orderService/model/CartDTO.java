package com.learning.orderService.model;

public class CartDTO {
	
	private int cartId;
	
	private boolean cartStatus;
	private String username;
    
    public CartDTO() {
		// TODO Auto-generated constructor stub
	}

    public CartDTO(String username) {
    	this.username = username;
	}
    
    public void setCartId(int cartId) {
		this.cartId = cartId;
	}
    
    public int getCartId() {
		return cartId;
	}
    
    public void setUsername(String username) {
		this.username = username;
	}
    
    public String getUsername() {
		return username;
	}
    
    public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}
    
    private boolean getCartStatus() {
		return this.cartStatus;
	}
 
	
}
