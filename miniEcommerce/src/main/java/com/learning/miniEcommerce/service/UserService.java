package com.learning.miniEcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.miniEcommerce.model.User;
import com.learning.miniEcommerce.model.UserPrincipal;
import com.learning.miniEcommerce.repository.UserDetailsRepository;


@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDetailsRepository userRepo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	@Lazy
	private AuthenticationManager authManager;
	
	private User loggedUser;
		
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		User user = userRepo.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("Username not found");
		return new UserPrincipal(user);
		
	}

	public void registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
	}

	public User getUser(String username) {
		System.out.println(username);
		return userRepo.findByUsername(username);
	}

	public String verifyUser(User user) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		System.out.println("User details:" +user.getFirstName()+" "+user.getLastName()+" "+user.getRole());
		if(authentication.isAuthenticated()) {
	        
			loggedUser = userRepo.findByUsername(user.getUsername());
	        String role = loggedUser.getRole(); // Fetch user role

			return jwtService.generateToken(user.getUsername(), role);
		}else
			return "Failed";
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
