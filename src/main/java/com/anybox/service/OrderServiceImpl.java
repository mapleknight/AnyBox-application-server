package com.anybox.service;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.OrderDAO;
import com.anybox.dao.OrderDetailDAO;
import com.anybox.dao.PreorderRecordDAO;
import com.anybox.model.Order;
import com.anybox.model.OrderDetail;
import com.anybox.model.OrderInfo;
import com.anybox.model.PreorderRecord;
import com.anybox.Exception.NotEnoughProductException;
import com.anybox.utils.Const;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired(required = true)
	@Qualifier(value = "orderDAO")
	private OrderDAO orderDAO;

	@Autowired(required = true)
	@Qualifier(value = "orderDetailDAO")
	private OrderDetailDAO orderDetailDAO;

	@Autowired(required = true)
	@Qualifier(value = "preorderRecordDAO")
	private PreorderRecordDAO preorderRecordDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	public Order create(OrderInfo o) {
		// create order
		Order order = o.getOrder();
		order.setCreateTime(new Date());
		order.setStatus(Const.ORDER_STATUS_FAILED);
		this.orderDAO.add(order);
		int orderId = order.getId();

		List<OrderDetail> odl = o.getDetail();

		// traverse order detail list
		for (OrderDetail od : odl) {
			// step 1, check if there are enough capacity for ordering
			Date odDate = od.getPickupDate();
			int productId = od.getProductId();
			int machineId = od.getMachineId();
			int amount = od.getProductNumber();

			DetachedCriteria dc2 = DetachedCriteria
					.forClass(PreorderRecord.class);
			dc2.add(Restrictions.eq("productId", productId));
			dc2.add(Restrictions.eq("machineId", machineId));
			dc2.add(Restrictions.eq("date", odDate));

			List<PreorderRecord> recordList = this.preorderRecordDAO
					.listWithCriteria(dc2);
			PreorderRecord pd = recordList.get(0);

			int capacity = pd.getCapacity();
			int orderedCapacity = pd.getPreorderCapacity();

			// step 2, if capacity not enough, throw runtime exception,
			// transaction rollback
			if (orderedCapacity + amount > capacity) {
				throw new NotEnoughProductException(odDate, productId, machineId);
			}

			// step 3, update PreorderRecord entry
			this.preorderRecordDAO.updatePreorderedCapacity(pd.getId(), amount);

			// step 4, double check whether capacity overflows
			PreorderRecord pdUpdated = this.preorderRecordDAO.getById(pd
					.getId());
			int updatedOrderedCapacity = pdUpdated.getPreorderCapacity();
			if (updatedOrderedCapacity > capacity) {
				throw new NotEnoughProductException(odDate, productId, machineId);
			}

			// step 5, insert entry to OrderDetail table
			od.setOrderId(orderId);
			this.orderDetailDAO.add(od);
		}

		order.setStatus(Const.ORDER_STATUS_UNPAID);
		this.orderDAO.update(order);

		return order;
	}

	@Override
	@Transactional
	public Order updateDetail(OrderDetail od) {
		//TODO should check capacity
		
		this.orderDetailDAO.update(od);
		return this.orderDAO.getById(od.getOrderId());
	}

	@Override
	@Transactional
	public Order updateDetailMultiple(List<OrderDetail> odList) {
		//TODO should check capacity
		
		for(OrderDetail od : odList) {
			this.orderDetailDAO.update(od);
		}
		return this.orderDAO.getById(odList.get(0).getOrderId());
	}

	@Override
	@Transactional
	public Order update(OrderInfo o) {
		//TODO should check capacity
		
		return this.updateDetailMultiple(o.getDetail());
	}

	@Override
	@Transactional
	public List<Order> list(int userId, String status) {
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.eq("user_id", userId));
		if (null != status && !status.equalsIgnoreCase("")) {
			dc.add(Restrictions.eq("status", status));
		} else {
			dc.add(Restrictions.ne("status", Const.ORDER_STATUS_DELETED));
		}

		List<Order> list = this.orderDAO.listWithCriteria(dc);

		return list;
	}

	@Override
	@Transactional
	public OrderInfo getById(int id) {
		
		OrderInfo oi = new OrderInfo();
		oi.setOrder(this.orderDAO.getById(id));
		
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.eq("order_id", id));
		oi.setDetail(this.orderDetailDAO.listWithCriteria(dc));
		
		return oi;
	}

	@Override
	@Transactional
	public void delete(int id) {
		Order o = new Order();
		o.setId(id);
		o.setStatus(Const.ORDER_STATUS_DELETED);
		this.orderDAO.update(o);
	}

}
