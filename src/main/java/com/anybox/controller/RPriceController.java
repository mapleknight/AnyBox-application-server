package com.anybox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.anybox.service.ProductService;

@Controller
public class RPriceController {

	@Autowired(required = true)
	@Qualifier(value = "productService")
	private ProductService productService;
	
}
