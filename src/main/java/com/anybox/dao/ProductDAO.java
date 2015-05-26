package com.anybox.dao;

import java.util.List;

import com.anybox.model.Product;

public interface ProductDAO {
	
	public Product add(Product p);
	public Product update(Product p);
	public List<Product> list();
	public Product getById(int id);
	public void delete(int id);

}
