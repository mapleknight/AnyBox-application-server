package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anybox.model.FreeLunch;

public class FreeLunchDAOImpl implements FreeLunchDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(FreeLunchDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public FreeLunch add(FreeLunch t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		logger.info("Add FreeLunch successfully, FreeLunch Details=" + t);
		return t;
	}

	@Override
	public FreeLunch update(FreeLunch t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update FreeLunch successfully, FreeLunch Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FreeLunch> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FreeLunch> freeLunchList = session.createQuery("from free_lunch").list();
		for(FreeLunch m : freeLunchList){
			logger.info("FreeLunch List:" + m);
		}
		return freeLunchList;
	}

	@Override
	public FreeLunch getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		FreeLunch m = (FreeLunch) session.load(FreeLunch.class, new Integer(id));
		logger.info("FreeLunch loaded successfully, FreeLunch details=" + m);
		return m;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		FreeLunch m = (FreeLunch) session.load(FreeLunch.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("FreeLunch deleted successfully, FreeLunch details=" + m);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FreeLunch> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<FreeLunch> list = cri.list();
		return list;
	}


}
