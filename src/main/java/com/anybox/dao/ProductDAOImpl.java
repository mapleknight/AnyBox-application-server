package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProductDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public Product add(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Add product successfully, product Details=" + p);
		return this.getByName(p.getName());
	}

	@Override
	public Product update(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Update product successfully, product Details=" + p);
		if(p.getId() > 0)
		{
			return this.getById(p.getId());
		}
		return this.getByName(p.getName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productList = session.createQuery("from Product").list();
		for(Product p : productList){
			logger.info("Product List:" + p);
		}
		return productList;
	}

	@Override
	public Product getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Product p = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded successfully, product details=" + p);
		return p;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Product deleted successfully, product details=" + p);
	}
	
	@SuppressWarnings("unchecked")
	private Product getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(Product.class);
		cri.add(Restrictions.eq("name", name));
		List<Product> list = cri.list();
		logger.info("Get Product info by name successfully, Product Details=" + list.get(0));
		return list.get(0);
	}

}
