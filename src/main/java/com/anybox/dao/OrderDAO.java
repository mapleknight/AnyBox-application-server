package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.Order;

public interface OrderDAO extends BasicDAO<Order> {

	List<Order> listWithCriteria(DetachedCriteria dc);

}
