package com.anybox.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(InventoryDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public Inventory add(Inventory i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(i);
		logger.info("Add Inventory successfully, Inventory Details=" + i);
		return i;
	}

	@Override
	public Inventory update(Inventory t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update Inventory successfully, Inventory Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Inventory> inventoryList = session.createQuery("from Inventory").list();
		for(Inventory m : inventoryList){
			logger.info("Inventory List:" + m);
		}
		return inventoryList;
	}

	@Override
	public Inventory getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Inventory m = (Inventory) session.load(Inventory.class, new Integer(id));
		logger.info("Inventory loaded successfully, Inventory details=" + m);
		return m;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Inventory m = (Inventory) session.load(Inventory.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Inventory deleted successfully, Inventory details=" + m);

	}

}
