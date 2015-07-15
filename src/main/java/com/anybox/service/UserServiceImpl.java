package com.anybox.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.Exception.UserNotExistException;
import com.anybox.dao.FreeLunchDAO;
import com.anybox.dao.UserDAO;
import com.anybox.model.FreeLunch;
import com.anybox.model.User;
import com.anybox.model.UserRefererModel;
import com.anybox.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService {
	
	public static final int EXPIRE_MONTH_NUMBER = 1;
	public static final int NOT_UPDATE_REFERER = 0;
	public static final int UPDATED_REFERER = 1;
	public static final double FREE_LUNCH_MONEY = 10.0;
	public static final int NOT_USED = 0;
	public static final int USED = 1;
	
	@Autowired(required=true)
	@Qualifier(value="userDAO")
	private UserDAO userDAO;
	
	@Autowired(required=true)
	@Qualifier(value="freeLunchDAO")
	private FreeLunchDAO freeLunchDAO;
	
	@Override
	@Transactional
	public User register(User u) throws UserNotExistException {
		u.setCreateTime(new Date());
		//TODO check email and phonenumber which should not be duplicate
		
		//create userCode, avoid repetition
		String md5 = "";
		try{
			md5 = MD5Utils.encoderByMd5(u.getEmail() + u.getPassword() + u.getEmail());
			md5 = md5.substring(0, 5);
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			dc.add(Restrictions.eq("userCode", md5));
			while(this.userDAO.listWithCriteria(dc).size() > 0) {
				md5 = MD5Utils.encoderByMd5(u.getEmail() + u.getPassword() + u.getEmail());
				md5 = md5.substring(0, 5);
				dc = DetachedCriteria.forClass(User.class);
				dc.add(Restrictions.eq("userCode", md5));
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		if(!"".equals(md5)) {
			u.setUserCode(md5);
		}
		
		//check inviteBy if it exists
		if(null != u.getInvitedBy()) {
			String refererCode = u.getInvitedBy();
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			dc.add(Restrictions.eq("userCode", refererCode));
			List<User> list = this.userDAO.listWithCriteria(dc);
			
			if(list.size() == 0) {
				throw new UserNotExistException("Referer not exists");
			}
			User referer = list.get(0);
			String refererName = referer.getFirstName() + " " + referer.getLastName();
			
			u.setInvitedBy(refererCode);
			u = this.userDAO.createUser(u);
			
			this.addFreeLunch(u.getId(), refererName, "Invited by ");
			u.setUpdateReferer(NOT_UPDATE_REFERER);
			//TODO when this user has payed once, the referer will get a free lunch opportunity
			this.addFreeLunch(referer.getId(), u.getFirstName() + " " + u.getLastName(), "Invite ");
		}
		else {
			u = this.userDAO.createUser(u);
		}
		
		return u;
	}

	@Override
	@Transactional
	public User login(User u) throws UserNotExistException {
		
		List<User> list = this.userDAO.getUserByEmailPwd(u);
		if(list.size() > 0)
		{
			return list.get(0);
		}
		
		throw new UserNotExistException("User not exists");
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}
	
	@Override
	@Transactional
	public boolean addFreeLunch(int userId, String refererName, String msg) {
		//add free lunch promocode to this user
		//TODO 邀请的人无法填写直接邀请人的码
		FreeLunch fl = new FreeLunch();
		
		TimeZone tz = TimeZone.getTimeZone("EST");
		Calendar cld = Calendar.getInstance(tz, Locale.US);
		cld.setTime(new Date());
		cld.add(Calendar.MONTH, EXPIRE_MONTH_NUMBER);
		fl.setExpire(cld.getTime());
		
		fl.setMoney(FREE_LUNCH_MONEY);
		fl.setStatus(NOT_USED);
		fl.setUserId(userId);
		
		fl.setDetail(msg + refererName);
		this.freeLunchDAO.add(fl);
		return true;
	}

	@Override
	@Transactional
	public List<FreeLunch> getFreeLunchList(int id) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(FreeLunch.class);
		dc.add(Restrictions.eq("status", 0));
		dc.add(Restrictions.eq("userId", id));
		
		return this.freeLunchDAO.listWithCriteria(dc);
	}
	
	@Override
	@Transactional
	public User updateUser(User u) {
		//TODO check  the fields to be updated, some fields are not allowed to be updated
		return this.userDAO.updateUser(u);
	}
	
	@Override
	@Transactional
	public User addReferer(UserRefererModel u) throws UserNotExistException {
		
		User oldUser = this.getUserById(u.getId());
		if(null == oldUser.getInvitedBy()){
			oldUser.setInvitedBy(u.getInviteBy());
			
			String refererCode = u.getInviteBy();
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			dc.add(Restrictions.eq("userCode", refererCode));
			List<User> list = this.userDAO.listWithCriteria(dc);
			
			if(list.size() == 0) {
				throw new UserNotExistException("Referer not exists");
			}
			User referer = list.get(0);
			String refererName = referer.getFirstName() + " " + referer.getLastName();
			
			//oldUser.setInvitedBy(refererCode);
			
			this.addFreeLunch(u.getId(), refererName, "Invited by ");
			oldUser.setUpdateReferer(NOT_UPDATE_REFERER);
			
			this.addFreeLunch(referer.getId(), oldUser.getFirstName() + " " + oldUser.getLastName(), "Invite ");
			
		}
		return this.userDAO.updateUser(oldUser);
	}

	@Override
	@Transactional
	public boolean checkUserExist(User u) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(u.getEmail() != null) {
			dc.add(Restrictions.eq("email", u.getEmail()));
			List<User> list = this.userDAO.listWithCriteria(dc);
			if(list.size() > 0) return true;
		} else if(u.getPhoneNumber() != null) {
			dc.add(Restrictions.eq("phoneNumber", u.getPhoneNumber()));
			List<User> list = this.userDAO.listWithCriteria(dc);
			if(list.size() > 0) return true;
		}
		
		return false;
	}
	
	//used for getting user info to change password
	@Override
	@Transactional
	public User getUserInfoByEmailorPhone(User u) throws UserNotExistException {
		
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(u.getEmail() != null) {
			dc.add(Restrictions.eq("email", u.getEmail()));
			List<User> list = this.userDAO.listWithCriteria(dc);
			if(list.size() > 0) return list.get(0);
		} else if(u.getPhoneNumber() != null) {
			dc.add(Restrictions.eq("phoneNumber", u.getPhoneNumber()));
			List<User> list = this.userDAO.listWithCriteria(dc);
			if(list.size() > 0) return list.get(0);
		} else throw new UserNotExistException("User not exist");
		
		return u;
	}

}
