package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exeption.ResourceNotFoundException;
import com.app.repository.ShoppingCartRepository;
import com.app.repository.UserRepository;
import com.app.entities.ShoppingCart;
import com.app.entities.User;

@Service // Mandatory , to tell SC , the following class contains B.L
@Transactional // Mandatory to tell SC to auto manage txs.
public class UserServiceImpl implements UserService {
	// dependency : dao layer i/f
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ShoppingCartRepository cartRepo;

	@Override
	public User authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepo.validateUser(email, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials , User not found!!"));
		return user;
	}// since User 1<--->1 ShoppingCart , eager , u can access cart's contents in
		// detached mode

	@Override
	public String addUserDetails(User user) {
		User persistentUser = userRepo.save(user);
		createUserCart(persistentUser);
		return "User registered with ID " + persistentUser.getId();
	}

	private void createUserCart(User user) {
		ShoppingCart newCart = new ShoppingCart();
		user.addCart(newCart);
		System.out.println("new cart created for user " + user.getFirstName());
	}

	@Override
	public User getUserDetails(long userId) {
		return  userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Id Invalid : User not found !!!"));		
	}

}
