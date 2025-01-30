package com.learning.miniEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.miniEcommerce.model.User;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

}
