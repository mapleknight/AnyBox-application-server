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

import com.anybox.model.Category;
import com.anybox.model.ResponseModel;
import com.anybox.service.CategoryService;
import com.anybox.utils.Const;

@Controller
public class RCategoryController {
	
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	private CategoryService categoryService;
	
	@RequestMapping(value = "/rcategory/{id}", method = RequestMethod.GET)
	public @ResponseBody Category getById(@PathVariable("id") int id) {
		return this.categoryService.getById(id);
	}
	
	@RequestMapping(value = "/rcategorys", method = RequestMethod.GET)
	public @ResponseBody List<Category> list(Model model) {
		return this.categoryService.list();
	}
	
	@RequestMapping(value= "/rcategory", method = RequestMethod.POST)
	public @ResponseBody Category add(@RequestBody Category c){
		
		if(c.getId() == 0){
			//new Category, add it
			return this.categoryService.add(c);
		}else{
			//existing Category, call update
			return this.categoryService.update(c);
		}
	}
	
	@RequestMapping(value = "/rcategory/remove/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel removeCustomer(@PathVariable("id") int id){
        this.categoryService.delete(id);
        
        ResponseModel rm = new ResponseModel();
        rm.setCode(Const.SUCCESS);
        return rm;
    }

}
