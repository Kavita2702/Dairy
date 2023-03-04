package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exeption.ResourceNotFoundException;
import com.app.repository.CartItemRepository;
import com.app.repository.ProductDao;
import com.app.repository.ShoppingCartRepository;
import com.app.entities.CartItems;
import com.app.entities.Product;
import com.app.entities.ShoppingCart;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
	// dep
	@Autowired
	private ShoppingCartRepository cartRepo;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private CartItemRepository cartItemRepo;

	@Override
	public String addProductToCart(long userId, long prodId, int quantity) {
		// get user cart
		ShoppingCart cart = cartRepo.findBycartownerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));

		// cart found
		// get product details from product id
		Product product = productDao.findById(prodId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not found!!!!!!!!"));
		// Check if the cart already has the cart item for the same product id. If yes
		// simply incr the quantity , total price : update cart item : this part not yet done !
		// if not : create a cart item 
		// If any discounts/offers are going on apply discount here
		double totalItemPrice = get() * quantity;
		CartItems newItem = new CartItems(quantity, totalItemPrice, cart, product);
		cart.getCartitems().add(newItem);
		CartItems savedItem = cartItemRepo.save(newItem);
		cart.setCartprice(cart.getCartprice() + totalItemPrice);
		cart.setCartItems(cart.getCartitems() + 1);
		return "Product added in the cart successfully !";
	}

	@Override
	public ShoppingCart getCartDetails(long userId) {
		// get user cart
		ShoppingCart cart = cartRepo.getCartWithCartItems(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		return cart;
	}

	@Override
	public double getTotalCartPrice(long userId) {
		ShoppingCart cart = cartRepo.findBycartownerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		return cart.getCartPrice();
	}

	@Override
	public int getTotalCartItems(long userId) {
		ShoppingCart cart = cartRepo.findBycartownerId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		return cart.getTotalitems();
	}

	@Override
	public String deleteCartContents(long userId) {
		// get user cart
		ShoppingCart cart = cartRepo.getCartWithCartItems(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not found!!!!!!!!"));
		//empty the cart here ....
		int deletedCartItems = cartItemRepo.deleteCartItems(cart.getId());
		cart.setTotalCartPrice(0);
		cart.setTotalItems(0);
		System.out.println("deleted cart items "+deletedCartItems);		
		return "user's cart emptied !!!!!";
	}

}
