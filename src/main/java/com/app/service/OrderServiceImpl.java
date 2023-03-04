package com.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exeption.ResourceNotFoundException;
import com.app.repository.OrderDetailRepository;
import com.app.repository.OrderRepository;
import com.app.repository.ShoppingCartRepository;
import com.app.entities.Order;
import com.app.entities.OrderDetails;
import com.app.entities.Product;
import com.app.entities.ShoppingCart;
import com.app.entities.Status;
import com.app.entities.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderDetailRepository orderDetailRepo;
	@Autowired
	private ShoppingCartRepository cartRepo;
	@Autowired
	private ShoppingCartService cartService;

	@Override
	public Order placeOrder(ShoppingCart cart) {
		// 1. create new order (transient) n save it
		Order order = new Order();
		Order savedOrder = orderRepo.save(order);
		// 2. get cart items n add it to order details
		cart.getCartitems().forEach(cartItem -> {
			// Leave the FUTURE scope for discount offer : to reduce or hike the cart item
			// (product) price --
			OrderDetails detail = new OrderDetails(cartItem.getQty(), cartItem.getTotalprice(),
					cartItem.getProduct());
			order.addOrderDetail(detail);
		});
		// assign customer to the order
		order.setCustomer(cart.getCartowner());
		order.setDeliveryDate(LocalDate.now().plusDays(4));// delivery date set after 4 days
		order.setOrderStatus(Status.ENTERED);// order details are entered BUT payment not yet done !
		order.setTotalPrice(cart.getCartprice());// here also later discount can be applied
		// NOT YET ADDED delivery address pojo : after u add it : set delivery address
		// B.L : orders cost > 500 , are delivered free , no shipping fees
		if (order.getTotalPrice() < 500)
			order.setShippingFee(75);// add the logic if it's within the same state or outside the state different !
										// currently hard coding the shipping charges : 75
		return savedOrder;
	}

	@Override
	public String completeOrder(long orderId, boolean status) {
		Order order = getOrderDetails(orderId);
		if (status) // => payment tx is successful !
		{
			// set order status to PLACED
			order.setOrderStatus(Status.PLACED);
			// empty the cart
			cartService.deleteCartContents(order.getCustomer().getId());
		} else
			order.setOrderStatus(Status.PAYMENT_FAILED);// not emptying the cart contents here : chk if you need any
														// modifications here
		return order.toString();
	}

	private Order getOrderDetails(long orderId) {
		return orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Invalid Order ID !!!"));
//				findTop1ByCustomerIdAndOrderStatus(userId, null)
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid order id , Order not found!!!!"));
	}

}
