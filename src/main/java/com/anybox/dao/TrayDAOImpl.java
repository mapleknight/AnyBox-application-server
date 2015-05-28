package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.Tray;

@Repository
public class TrayDAOImpl implements TrayDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(TrayDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Tray add(Tray t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		logger.info("Add tray successfully, tray Details=" + t);
		return t;
	}

	@Override
	public Tray update(Tray t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update tray successfully, tray Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tray> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Tray> trayList = session.createQuery("from Tray").list();
		for (Tray t : trayList) {
			logger.info("Tray List:" + t);
		}
		return trayList;
	}

	@Override
	public Tray getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Tray t = (Tray) session.load(Tray.class, new Integer(id));
		logger.info("Tray loaded successfully, tray details=" + t);
		return t;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Tray t = (Tray) session.load(Tray.class, new Integer(id));
		if (null != t) {
			session.delete(t);
		}
		logger.info("Tray deleted successfully, tray details=" + t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tray> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<Tray> list = cri.list();

		return list;
	}

}
