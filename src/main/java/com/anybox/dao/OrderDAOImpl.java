package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public Order add(Order o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(o);
		logger.info("Add Order successfully, Order Details=" + o);
		return o;
	}

	@Override
	public Order update(Order t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update Order successfully, Order Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order").list();
		for(Order m : orderList){
			logger.info("Order List:" + m);
		}
		return orderList;
	}

	@Override
	public Order getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Order m = (Order) session.load(Order.class, new Integer(id));
		logger.info("Order loaded successfully, Order details=" + m);
		return m;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order m = (Order) session.load(Order.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Order deleted successfully, Order details=" + m);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<Order> list = cri.list();
		return list;
	}

}
