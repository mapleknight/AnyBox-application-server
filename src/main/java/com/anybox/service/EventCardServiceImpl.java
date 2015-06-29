package com.anybox.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.EventCardDAO;
import com.anybox.model.EventCard;

@Service
public class EventCardServiceImpl implements EventCardService {

	@Autowired(required=true)
	@Qualifier(value="eventCardDAO")
	private EventCardDAO eventCardDAO;
	
	@Override
	@Transactional
	public EventCard add(EventCard t) {
		return this.eventCardDAO.add(t);
	}

	@Override
	@Transactional
	public EventCard update(EventCard t) {
		return this.eventCardDAO.update(t);
	}

	@Override
	@Transactional
	public List<EventCard> list() {
		
		//TODO check the bug
		return this.eventCardDAO.list();
	}
	
	@Override
	@Transactional
	public List<EventCard> listWithValid() {
		DetachedCriteria dc = DetachedCriteria.forClass(EventCard.class);
		dc.add(Restrictions.eq("valid", 1));

		List<EventCard> list = this.eventCardDAO.listWithCriteria(dc);

		return list;
		//return this.eventCardDAO.list();
	}

	@Override
	@Transactional
	public EventCard getById(int id) {
		return this.eventCardDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.eventCardDAO.delete(id);
	}

}
