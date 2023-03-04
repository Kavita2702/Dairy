package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

	
	Optional<ShoppingCart> findBycartownerId(long customerId);
	@Query("select c from ShoppingCart c left outer join fetch c.cartItems where c.cartOwner.id=?1")
	Optional<ShoppingCart> getCartWithCartItems(long customerId);
	
	
}
