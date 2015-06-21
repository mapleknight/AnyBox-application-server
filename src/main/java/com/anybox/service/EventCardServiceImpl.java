package com.anybox.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anybox.dao.EventCardDAO;
import com.anybox.model.EventCard;

@Service
public class EventCardServiceImpl implements EventCardService {

	@Autowired(required=true)
	@Qualifier(value="eventCardDAO")
	private EventCardDAO eventCardDAO;
	
	@Override
	public EventCard add(EventCard t) {
		return this.eventCardDAO.add(t);
	}

	@Override
	public EventCard update(EventCard t) {
		return this.eventCardDAO.update(t);
	}

	@Override
	public List<EventCard> list() {
		return this.eventCardDAO.list();
	}
	
	@Override
	public List<EventCard> listWithValid() {
		DetachedCriteria dc = DetachedCriteria.forClass(EventCard.class);
		dc.add(Restrictions.eq("valid", 1));

		List<EventCard> list = this.eventCardDAO.listWithCriteria(dc);

		return list;
	}

	@Override
	public EventCard getById(int id) {
		return this.eventCardDAO.getById(id);
	}

	@Override
	public void delete(int id) {
		this.eventCardDAO.delete(id);
	}

}
