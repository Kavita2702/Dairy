package com.app.service;

import com.app.entities.User;

public interface UserService {
//add a B.L method for user authentication
	User authenticateUser(String email,String password);
	String addUserDetails(User user);
	//get user details
	User getUserDetails(long userId);
}
