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

import com.anybox.model.EventCard;
import com.anybox.model.ResponseModel;
import com.anybox.service.EventCardService;
import com.anybox.utils.Const;

@Controller
public class REventCardController {
	
	@Autowired(required=true)
	@Qualifier(value="eventCardService")
	private EventCardService eventCardService;
	
	@RequestMapping(value = "/reventcard/{id}", method = RequestMethod.GET)
	public @ResponseBody EventCard getById(@PathVariable("id") int id) {
		return this.eventCardService.getById(id);
	}
	
	@RequestMapping(value = "/reventcards", method = RequestMethod.GET)
	public @ResponseBody List<EventCard> list(Model model) {
		return this.eventCardService.listWithValid();
	}
	
	@RequestMapping(value= "/reventcard", method = RequestMethod.POST)
	public @ResponseBody EventCard add(@RequestBody EventCard c){
		if(c.getId() == 0){
			//new EventCard, add it
			return this.eventCardService.add(c);
		}else{
			//existing EventCard, call update
			return this.eventCardService.update(c);
		}
	}
	
	@RequestMapping(value = "/reventcard/remove/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel removeEventCard(@PathVariable("id") int id){
        this.eventCardService.delete(id);
        
        ResponseModel rm = new ResponseModel();
        rm.setCode(Const.SUCCESS);
        return rm;
    }

}
