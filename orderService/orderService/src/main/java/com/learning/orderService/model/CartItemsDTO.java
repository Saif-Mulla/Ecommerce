package com.learning.orderService.model;

public class CartItemsDTO {
	
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
