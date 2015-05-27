package com.anybox.dao;

import java.util.List;

import com.anybox.model.Order;

public interface OrderDAO {
	
	public Order add(Order t);
	public Order update(Order t);
	public List<Order> list();
	public Order getById(int id);
	public void delete(int id);

}
