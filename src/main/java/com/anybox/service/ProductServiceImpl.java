package com.anybox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.ProductDAO;
import com.anybox.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required=true)
	@Qualifier(value="productDAO")
	private ProductDAO productDAO;

	@Override
	@Transactional
	public Product add(Product p) {
		return this.productDAO.add(p);
	}

	@Override
	@Transactional
	public Product update(Product p) {
		return this.productDAO.update(p);
	}

	@Override
	@Transactional
	public List<Product> list() {
		return this.productDAO.list();
	}

	@Override
	@Transactional
	public Product getById(int id) {
		return this.productDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.productDAO.delete(id);
	}

}
