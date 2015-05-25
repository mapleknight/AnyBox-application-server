package com.anybox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anybox.model.User;
import com.anybox.service.UserService;

@Controller
public class RUserController {
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	private UserService userService;
	
	@RequestMapping(value= "/ruser/register", method = RequestMethod.POST)
	public @ResponseBody User register(@RequestBody User u){
		
		User user = this.userService.register(u);
		
		return user;
	}
	
	@RequestMapping(value= "/ruser/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody User u){
		
		User user = this.userService.login(u);
		
		return user;
	}
	
	@RequestMapping(value= "/ruser/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") int id){
		
		User user = this.userService.getUserById(id);
		
		return user;
	}
	

}
