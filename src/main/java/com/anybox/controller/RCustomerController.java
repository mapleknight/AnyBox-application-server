package com.anybox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anybox.model.Customer;
import com.anybox.service.CustomerService;

@Controller
public class RCustomerController {
	
	private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService cs){
		this.customerService = cs;
	}
	
	@RequestMapping(value = "/rcustomers", method = RequestMethod.GET)
	public @ResponseBody List<Customer> listCustomers(Model model) {
		return this.customerService.listCustomers();
	}
	
	//For add and update customer both
	@RequestMapping(value= "/rcustomer/add", method = RequestMethod.POST)
	public @ResponseBody String addCustomer(@RequestBody Customer c){
		
		if(c.getId() == 0){
			//new customer, add it
			this.customerService.addCustomer(c);
			return "Successfully Added customer with id " + c.getId();
		}else{
			//existing customer, call update
			this.customerService.updateCustomer(c);
			return "Successfully Updated customer with id " + c.getId();
		}
	}
	
	@RequestMapping(value = "/rremove/{id}", method = RequestMethod.PUT)
    public @ResponseBody String removeCustomer(@PathVariable("id") int id){
		
        this.customerService.removeCustomer(id);
        //return "redirect:/customers";
        return "Successfully Removed customer with id " + id;
    }	
}
