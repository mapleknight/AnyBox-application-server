package com.anybox.service;

import java.util.List;

import com.anybox.model.Category;


public interface CategoryService {
	
	public void addCategory(Category c);
	public void updateCategory(Category c);
	public List<Category> listCategory();
	public Category getCategoryById(int id);
	public void deleteCategory(int id);

}
