package com.anybox.service;

import java.util.List;

import com.anybox.model.Order;
import com.anybox.model.OrderDetail;
import com.anybox.model.OrderInfo;

public interface OrderService {
	
	public Order create(OrderInfo o);
	
	/**
	 * update product info of order
	 * @param od
	 * @return
	 */
	public Order updateDetail(OrderDetail od);
	
	/**
	 * update multiple product info of order
	 * @param od
	 * @return
	 */
	public Order updateDetailMultiple(List<OrderDetail> odList);
	
	/**
	 * update order
	 * @param od
	 * @return
	 */
	public Order update(OrderInfo od);
	
	/**
	 * query OrderInfo list of a user
	 * @param userId
	 * @param status
	 * @return
	 */
	public List<OrderInfo> list(int userId, String status);
	
	public OrderInfo getById(int id);
	
	/**
	 * update order
	 * @param od
	 * @return
	 */
	public void delete(int id);
	
}
