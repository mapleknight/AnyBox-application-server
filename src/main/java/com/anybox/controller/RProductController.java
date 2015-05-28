package com.anybox.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anybox.model.Product;
import com.anybox.model.ProductWithDetail;
import com.anybox.model.ResponseModel;
import com.anybox.service.ProductService;
import com.anybox.utils.Const;

@Controller
public class RProductController {
	
	@Autowired(required=true)
	@Qualifier(value="productService")
	private ProductService productService;
	
	@RequestMapping(value = "/rproduct/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getById(@PathVariable("id") int id) {
		return this.productService.getById(id);
	}
	
	@RequestMapping(value = "/rproducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> list(Model model) {
		return this.productService.list();
	}
	
	@RequestMapping(value = "/rproduct/list", method = RequestMethod.GET)
	public @ResponseBody List<ProductWithDetail> listWithDetail(@RequestParam("machineId") int machineId,
			@RequestParam("userId") int userId, @RequestParam("date") String date) {
		
		return this.productService.listWithDetail(machineId, userId, date);
	}
	
	@RequestMapping(value= "/rproduct", method = RequestMethod.POST)
	public @ResponseBody Product add(@RequestBody Product c){
		if(c.getId() == 0){
			//new product, add it
			return this.productService.add(c);
		}else{
			//existing product, call update
			return this.productService.update(c);
		}
		
	}
	
	@RequestMapping(value = "/rproduct/remove/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel removeCustomer(@PathVariable("id") int id){
        this.productService.delete(id);
        
        ResponseModel rm = new ResponseModel();
        rm.setCode(Const.SUCCESS);
        return rm;
    }
	

}
