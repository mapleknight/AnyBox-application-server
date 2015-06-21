package com.anybox.service;

import java.util.List;

import com.anybox.model.EventCard;

public interface EventCardService extends BasicService<EventCard> {

	List<EventCard> listWithValid();

}
