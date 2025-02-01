package com.learning.CartService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.CartService.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	Optional<Cart> findByUsername(String username);

}
