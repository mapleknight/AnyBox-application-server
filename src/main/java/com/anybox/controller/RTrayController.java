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

import com.anybox.model.ResponseModel;
import com.anybox.model.Tray;
import com.anybox.service.TrayService;
import com.anybox.utils.Const;

@Controller
public class RTrayController {
	
	@Autowired(required=true)
	@Qualifier(value="trayService")
	private TrayService trayService;
	
	@RequestMapping(value = "/rtray/{id}", method = RequestMethod.GET)
	public @ResponseBody Tray getById(@PathVariable("id") int id) {
		return this.trayService.getById(id);
	}
	
	@RequestMapping(value = "/rtrays", method = RequestMethod.GET)
	public @ResponseBody List<Tray> list(Model model) {
		return this.trayService.list();
	}
	
	@RequestMapping(value= "/rtray", method = RequestMethod.POST)
	public @ResponseBody Tray add(@RequestBody Tray c){
		if(c.getId() == 0){
			//new Tray, add it
			return this.trayService.add(c);
		}else{
			//existing Tray, call update
			return this.trayService.update(c);
		}
	}
	
	@RequestMapping(value = "/rtray/remove/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel removeCustomer(@PathVariable("id") int id){
        this.trayService.delete(id);
        
        ResponseModel rm = new ResponseModel();
        rm.setCode(Const.SUCCESS);
        return rm;
    }

}
