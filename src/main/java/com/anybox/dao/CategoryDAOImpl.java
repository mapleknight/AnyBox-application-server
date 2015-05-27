package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CategoryDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Category add(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(c);
		logger.info("Add category successfully, category Details=" + c);
		return c;
	}

	@Override
	public Category update(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Update category successfully, category Details=" + c);
		return this.getById(c.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Product").list();
		for(Category c : categoryList){
			logger.info("Category List:" + c);
		}
		return categoryList;
	}

	@Override
	public Category getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Category c = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, category details=" + c);
		return c;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category c = (Category) session.load(Category.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Category deleted successfully, category details=" + c);

	}

}
