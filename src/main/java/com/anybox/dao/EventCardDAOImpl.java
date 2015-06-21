package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.EventCard;

@Repository
public class EventCardDAOImpl implements EventCardDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(EventCardDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public EventCard add(EventCard t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		logger.info("Add EventCard successfully, EventCard Details=" + t);
		return t;
	}

	@Override
	public EventCard update(EventCard t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update EventCard successfully, EventCard Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventCard> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<EventCard> eventCardList = session.createQuery("from event_card").list();
		for(EventCard m : eventCardList){
			logger.info("EventCard List:" + m);
		}
		return eventCardList;
	}

	@Override
	public EventCard getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		EventCard o = (EventCard) session.load(EventCard.class, new Integer(id));
		logger.info("EventCard loaded successfully, EventCard details=" + o);
		return o;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		EventCard o = (EventCard) session.load(EventCard.class, new Integer(id));
		if(null != o){
			session.delete(o);
		}
		logger.info("EventCard deleted successfully, EventCard details=" + o);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EventCard> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<EventCard> list = cri.list();
		return list;
	}

}
