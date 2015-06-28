package com.anybox.service;

import java.util.List;

import com.anybox.Exception.UserNotExistException;
import com.anybox.model.FreeLunch;
import com.anybox.model.User;

public interface UserService {
	
	public User register(User u) throws UserNotExistException;
	
	public User login(User u) throws UserNotExistException;
	
	public User getUserById(int id);
	
	public List<FreeLunch> getFreeLunchList(int id);

	public boolean addFreeLunch(int userId, String refererName);

	public User updateUser(User u);

}
