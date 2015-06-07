package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anybox.model.Policy;

public class PolicyDAOImpl implements PolicyDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PolicyDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Policy add(Policy t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		logger.info("Add Policy successfully, Policy Details=" + t);
		return t;
	}

	@Override
	public Policy update(Policy t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update Policy successfully, Policy Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Policy> policyList = session.createQuery("from Policy").list();
		for(Policy p : policyList){
			logger.info("Policy List:" + p);
		}
		return policyList;
	}

	@Override
	public Policy getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Policy p = (Policy) session.load(Policy.class, new Integer(id));
		logger.info("Policy loaded successfully, Policy details=" + p);
		return p;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Policy p = (Policy) session.load(Policy.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Policy deleted successfully, Policy details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Policy> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<Policy> list = cri.list();
		return list;
	}

}
