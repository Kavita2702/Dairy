package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
//add a method to get the products by chosen category
//	List<Product> getProductsByCategory(long categoryId);
	List<Product> findByProductCategoryId(long categoryId);
	
}
