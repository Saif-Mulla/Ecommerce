package com.learning.CartService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.CartService.model.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
	List<CartItems> findByCartId(int cartId);
}
