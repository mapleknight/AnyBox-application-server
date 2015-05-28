package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.OrderDetail;

public interface OrderDetailDAO extends BasicDAO<OrderDetail> {

	List<OrderDetail> listWithCriteria(DetachedCriteria dc);

}
