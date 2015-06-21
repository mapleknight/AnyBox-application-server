package com.anybox.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.anybox.service.OrderService;

@Controller
public class RPriceController {

	@Autowired(required = true)
	@Qualifier(value = "orderService")
	private OrderService orderService;
	
	
//	@RequestMapping(value = "/rprice/calculate", method = RequestMethod.POST)
//	public @ResponseBody List<ProductWithDetail> listWithDetail(@RequestBody CalculatePriceRequestBody cprb) {
//		
//		return this.orderService.calculatePrice(cprb);
//	}
	
}
