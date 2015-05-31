package com.anybox.service;

import com.anybox.Exception.UserNotExistException;
import com.anybox.model.User;

public interface UserService {
	
	public User register(User u);
	
	public User login(User u) throws UserNotExistException;
	
	public User getUserById(int id);

}
