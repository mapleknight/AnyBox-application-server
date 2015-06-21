package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.EventCard;

public interface EventCardDAO extends BasicDAO<EventCard> {

	List<EventCard> listWithCriteria(DetachedCriteria dc);
	
	

}
