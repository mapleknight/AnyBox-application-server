package com.anybox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anybox.model.Order;
import com.anybox.model.OrderInfo;
import com.anybox.model.ResponseModel;
import com.anybox.service.OrderService;
import com.anybox.utils.Const;

@Controller
public class ROrderController {
	
	@Autowired(required=true)
	@Qualifier(value="orderService")
	private OrderService orderService;
	
	@RequestMapping(value = "/rorder/add", method = RequestMethod.POST)
	public @ResponseBody Order create(OrderInfo oi) {
		return this.orderService.create(oi);
	}
	
	@RequestMapping(value = "/rorder/list/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Order> listWithUserId(@PathVariable("userId") int userId) {
		return this.orderService.list(userId, "");
	}
	
	@RequestMapping(value = "/rorder/{id}", method = RequestMethod.GET)
	public @ResponseBody OrderInfo getById(@PathVariable("id") int id) {
		return this.orderService.getById(id);
	}
	
	@RequestMapping(value = "/rorder/remove/{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel delete(@PathVariable("id") int id) {
		
		this.orderService.delete(id);
		ResponseModel rm = new ResponseModel();
	    rm.setCode(Const.SUCCESS);
		return rm;
	}
	
	

}
