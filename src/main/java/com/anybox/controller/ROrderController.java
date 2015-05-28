package com.anybox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anybox.model.Order;
import com.anybox.model.OrderInfo;
import com.anybox.service.OrderService;

@Controller
public class ROrderController {
	
	@Autowired(required=true)
	@Qualifier(value="orderService")
	private OrderService orderService;
	
	@RequestMapping(value = "/rorder/add", method = RequestMethod.GET)
	public @ResponseBody Order getById(OrderInfo oi) {
		this.orderService.create(oi);
		return null;
	}

}
