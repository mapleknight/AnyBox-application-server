package com.anybox.dao;

import java.util.List;

import com.anybox.model.Category;

public interface CategoryDAO {
	
	public Category add(Category c);
	public Category update(Category c);
	public List<Category> list();
	public Category getById(int id);
	public void delete(int id);

}
