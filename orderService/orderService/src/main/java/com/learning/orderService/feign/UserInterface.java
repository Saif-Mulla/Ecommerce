package com.learning.orderService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.learning.orderService.model.UserDTO;


@FeignClient("MINIECOMMERCE")
public interface UserInterface {
	
	@GetMapping("/user/profile/{username}")
	public UserDTO getUser(@PathVariable String username);
	
	@GetMapping("/user/isLogin")
	public UserDTO getLoggedInUser(@RequestHeader("Authorization") String token);
	

}

