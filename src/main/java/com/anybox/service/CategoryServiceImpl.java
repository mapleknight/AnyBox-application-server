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
	public void addCategory(Category c) {
		
		this.categoryDAO.addCategory(c);

	}

	@Override
	@Transactional
	public void updateCategory(Category c) {
		
		this.categoryDAO.updateCategory(c);

	}

	@Override
	@Transactional
	public List<Category> listCategory() {
		
		return this.categoryDAO.listCategory();
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		
		return this.categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public void deleteCategory(int id) {
		this.categoryDAO.deleteCategory(id);
	}

}
