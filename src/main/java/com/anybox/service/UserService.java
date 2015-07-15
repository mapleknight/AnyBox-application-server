package com.anybox.service;

import java.util.List;

import com.anybox.Exception.UserNotExistException;
import com.anybox.model.FreeLunch;
import com.anybox.model.User;
import com.anybox.model.UserRefererModel;

public interface UserService {
	
	public User register(User u) throws UserNotExistException;
	
	public User login(User u) throws UserNotExistException;
	
	public User getUserById(int id);
	
	public List<FreeLunch> getFreeLunchList(int id);

	public boolean addFreeLunch(int userId, String refererName, String msg);

	public User updateUser(User u);


	public User addReferer(UserRefererModel u) throws UserNotExistException;

	public boolean checkUserExist(User u);

	public User getUserInfoByEmailorPhone(User u) throws UserNotExistException;

}
