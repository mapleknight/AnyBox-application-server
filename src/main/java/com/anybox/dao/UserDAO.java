package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.User;

public interface UserDAO {
	
	/**
	 * user register
	 * @param User u
	 * @return User
	 */
	public User createUser(User u);
	
	/**
	 * for user login
	 * @param User u
	 * @return User
	 */
	public List<User> getUserByEmailPwd(User u);
	
	/**
	 * for user
	 * @param User u
	 * @return User
	 */
	public User getUserByEmail(String email);
	
	/**
	 * get user info
	 * @param User u
	 * @return User
	 */
	public User getUserById(int id);
	
	
	public User UpdateUser(User u);
	
	public List<User> listWithCriteria(DetachedCriteria dc);

}
