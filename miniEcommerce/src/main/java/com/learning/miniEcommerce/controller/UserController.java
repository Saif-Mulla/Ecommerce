package com.learning.miniEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.miniEcommerce.model.User;
import com.learning.miniEcommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public void registerUser(@RequestBody User user) {
		System.out.println(user.getFirstName() +" "+ user.getLastName() +" "+ user.getStatus() +" "+ user.getRole() +" "+ user.getUsername());
		userService.registerUser(user);
	}
	
	@GetMapping("/profile/{username}")
	public User getUser(@PathVariable String username) {
		System.out.println("CONTROLLER");
		return userService.getUser(username);
	}
	
	@GetMapping("/isLogin")
	public User getLoggedInUser() {
		return userService.getLoggedInUser();
		
	}
	
	@GetMapping("/admin/users")
	public ResponseEntity<List<User>> getAllUsers() {
		
		if(userService.getAllUsers() != null)
			return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.FOUND);
		else
			return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		String generatedToken = userService.verifyUser(user);
		return new ResponseEntity<String>(generatedToken,HttpStatus.FOUND);
		
	}
	
	
}
