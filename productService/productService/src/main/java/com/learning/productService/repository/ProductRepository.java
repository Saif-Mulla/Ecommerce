package com.learning.productService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.productService.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {

	@Query("SELECT p from Product p WHERE "
			+ "LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(p.productBrand) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Product> findByKeyword(String keyword);

}
