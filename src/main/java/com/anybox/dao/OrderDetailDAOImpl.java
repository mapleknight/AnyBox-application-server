package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.OrderDetail;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderDetailDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public OrderDetail add(OrderDetail t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		logger.info("Add OrderDetail successfully, OrderDetail Details=" + t);
		return t;
	}

	@Override
	public OrderDetail update(OrderDetail t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update OrderDetail successfully, OrderDetail Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<OrderDetail> orderDetailList = session.createQuery("from Order_detail").list();
		for(OrderDetail o : orderDetailList){
			logger.info("OrderDetail List:" + o);
		}
		return orderDetailList;
	}

	@Override
	public OrderDetail getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		OrderDetail o = (OrderDetail) session.load(OrderDetail.class, new Integer(id));
		logger.info("OrderDetail loaded successfully, OrderDetail details=" + o);
		return o;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OrderDetail o = (OrderDetail) session.load(OrderDetail.class, new Integer(id));
		if(null != o){
			session.delete(o);
		}
		logger.info("OrderDetail deleted successfully, OrderDetail details=" + o);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<OrderDetail> list = cri.list();
		return list;
	}

}
