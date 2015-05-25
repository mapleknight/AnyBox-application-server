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
	public void addProduct(Product p) {
		this.productDAO.addProduct(p);

	}

	@Override
	@Transactional
	public void updateProduct(Product p) {
		this.productDAO.updateProduct(p);

	}

	@Override
	@Transactional
	public List<Product> listProduct() {
		
		return this.productDAO.listProduct();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		
		return this.productDAO.getProductById(id);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		
		this.productDAO.deleteProduct(id);

	}

}
