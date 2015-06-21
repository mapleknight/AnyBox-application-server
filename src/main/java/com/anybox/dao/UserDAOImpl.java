package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.OrderDetail;
import com.anybox.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public User createUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("User registered successfully, User Details=" + u);
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByEmailPwd(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(User.class);
		cri.add(Restrictions.eq("email", u.getEmail()));
		cri.add(Restrictions.eq("password", u.getPassword()));
		List<User> list = cri.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(User.class);
		cri.add(Restrictions.eq("email", email));
		List<User> list = cri.list();
		logger.info("Get user info by email successfully, User Details=" + list.get(0));
		return list.get(0);
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, id);
		logger.info("Get user info by id successfully, User Details=" + u);
		return u;
	}

	@Override
	public User UpdateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		User _u = this.getUserById(u.getId());
		
		logger.info("Update user info successfully, User Details=" + u);
		
		return _u;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<User> list = cri.list();
		return list;
	}

}
