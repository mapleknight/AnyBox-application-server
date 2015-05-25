package com.anybox.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public void addCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Add category successfully, category Details=" + c);
	}

	@Override
	public void updateCategory(Category c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Update category successfully, category Details=" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Product").list();
		for(Category c : categoryList){
			logger.info("Category List:" + c);
		}
		return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Category c = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, category details=" + c);
		return c;
	}

	@Override
	public void deleteCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category c = (Category) session.load(Category.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Category deleted successfully, category details=" + c);

	}

}
