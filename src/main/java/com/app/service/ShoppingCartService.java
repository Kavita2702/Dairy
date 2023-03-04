package com.app.service;

import com.app.entities.ShoppingCart;

public interface ShoppingCartService {
	String addProductToCart(long userId, long prodId, int quantity);
	ShoppingCart getCartDetails(long userId);
	double getTotalCartPrice(long userId);
	int getTotalCartItems(long userId);
//	String deleteCart(long userId);
	String deleteCartContents(long userId);
}
