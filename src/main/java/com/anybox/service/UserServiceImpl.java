package com.anybox.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.UserDAO;
import com.anybox.model.User;
import com.anybox.utils.Const;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required=true)
	@Qualifier(value="userDAO")
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User register(User u) {
		
		u.setCreateTime(new Date());
		
		return this.userDAO.createUser(u);
	}

	@Override
	@Transactional
	public User login(User u) {
		
		List<User> list = this.userDAO.getUserByEmailPwd(u);
		if(list.size() > 0)
		{
			return list.get(0);
		}
		
		User user = new User();
		user.setId(Const.errTag);
		return user;
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

}
