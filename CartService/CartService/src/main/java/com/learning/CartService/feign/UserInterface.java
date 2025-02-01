package com.learning.CartService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.learning.CartService.dto.UserDto;

@FeignClient("MINIECOMMERCE")
public interface UserInterface {
	
	@GetMapping("/user/profile/{username}")
	public UserDto getUser(@PathVariable String username);
	
	@GetMapping("/user/isLogin")
	public UserDto getLoggedInUser(@RequestHeader("Authorization") String token);
	

}
