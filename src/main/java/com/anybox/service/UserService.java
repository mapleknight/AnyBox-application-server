package com.anybox.service;

import com.anybox.model.User;

public interface UserService {
	
	public User register(User u);
	
	public User login(User u);
	
	public User getUserById(int id);

}
