package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.CartItems;


public interface CartItemRepository extends JpaRepository<CartItems, Long> {
	//empty cart contents
	@Modifying
	@Query("delete from CartItem c where c.myCart.id=?1")
	int deleteCartItems(long cartId);

}
