package com.learning.CartService.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ProductDto {
	private int productId;
	private String productName;
	private double productPrice;
	private String productBrand;
	private String category;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date releaseDate;
	private Boolean available;
	private int quantity;
	
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDto(int productId, String productName, double productPrice, String productBrand, String category, Date releaseDate, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productBrand = productBrand;
		this.category = category;
		this.releaseDate = releaseDate;
		this.available = true;
		this.quantity = quantity;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Boolean getAvailable() {
		return available;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getProductBrand() {
		return productBrand;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	@Override
	public String toString() {
	    return "Product{" +
	           "productId=" + productId +
	           ", productName='" + productName + '\'' +
	           ", productPrice=" + productPrice +
	           '}';
	}

}
