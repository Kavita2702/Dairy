package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Order;
import com.app.entities.Status;

public interface OrderRepository extends JpaRepository<Order, Long> {
	//search for the top order , placed by a specific customer , whose order status = ENTERED(NEW) 
	Optional<Order> findTop1ByCustomerIdAndOrderStatus(long userId,Status status);
}
