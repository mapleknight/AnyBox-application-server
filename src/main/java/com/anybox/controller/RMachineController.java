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

import com.anybox.model.Machine;
import com.anybox.model.ResponseModel;
import com.anybox.service.MachineService;
import com.anybox.utils.Const;

@Controller
public class RMachineController {
	
	@Autowired(required=true)
	@Qualifier(value="machineService")
	private MachineService machineService;
	
	@RequestMapping(value = "/rmachine/{id}", method = RequestMethod.GET)
	public @ResponseBody Machine getById(@PathVariable("id") int id) {
		return this.machineService.getById(id);
	}
	
	@RequestMapping(value = "/rmachines", method = RequestMethod.GET)
	public @ResponseBody List<Machine> list(Model model) {
		return this.machineService.list();
	}
	
	@RequestMapping(value= "/rmachine", method = RequestMethod.POST)
	public @ResponseBody Machine add(@RequestBody Machine c){
		if(c.getId() == 0){
			//new Machine, add it
			return this.machineService.add(c);
		}else{
			//existing Machine, call update
			return this.machineService.update(c);
		}
	}
	
	@RequestMapping(value = "/rmachine/remove/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel removeMachine(@PathVariable("id") int id){
        this.machineService.delete(id);
        
        ResponseModel rm = new ResponseModel();
        rm.setCode(Const.SUCCESS);
        return rm;
    }

}
