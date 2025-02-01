package com.learning.CartService.dto;

public class UserDto {
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private boolean isActive;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setStatus(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean getStatus() {
		return isActive;
	}

}
