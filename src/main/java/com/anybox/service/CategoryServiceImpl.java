package com.anybox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.CategoryDAO;
import com.anybox.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired(required=true)
	@Qualifier(value="categoryDAO")
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public Category add(Category c) {
		return this.categoryDAO.add(c);
	}

	@Override
	@Transactional
	public Category update(Category c) {
		return this.categoryDAO.update(c);

	}

	@Override
	@Transactional
	public List<Category> list() {
		
		return this.categoryDAO.list();
	}

	@Override
	@Transactional
	public Category getById(int id) {
		
		return this.categoryDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.categoryDAO.delete(id);
	}

}
