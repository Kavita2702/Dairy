package com.app.service;

import com.app.entities.Order;
import com.app.entities.ShoppingCart;

public interface OrderService {
//add a B.L method to place the order
	Order placeOrder(ShoppingCart cart);
	String completeOrder(long orderId,boolean status);
}
