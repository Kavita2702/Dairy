package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Order;
import com.app.entities.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {

}
