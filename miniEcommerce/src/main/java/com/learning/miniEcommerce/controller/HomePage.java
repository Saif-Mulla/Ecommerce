package com.learning.miniEcommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")
public class HomePage {

	@RequestMapping("/")
	public String greeting() {
		return "Hello!";
		
	}
	
}
