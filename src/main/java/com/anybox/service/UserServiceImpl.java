package com.anybox.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.Exception.UserNotExistException;
import com.anybox.dao.UserDAO;
import com.anybox.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required=true)
	@Qualifier(value="userDAO")
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User register(User u) {
		
		u.setCreateTime(new Date());
		//TODO 
		//create userCode, avoid repetition
		
		return this.userDAO.createUser(u);
	}

	@Override
	@Transactional
	public User login(User u) throws UserNotExistException {
		
		List<User> list = this.userDAO.getUserByEmailPwd(u);
		if(list.size() > 0)
		{
			return list.get(0);
		}
		
		throw new UserNotExistException();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

}
