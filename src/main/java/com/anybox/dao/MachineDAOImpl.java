package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.Machine;

@Repository
public class MachineDAOImpl implements MachineDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(MachineDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Machine add(Machine t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Add machine successfully, machine Details=" + t);
		return this.getByName(t.getName());
	}

	@Override
	public Machine update(Machine t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update machine successfully, machine Details=" + t);
		
		if(t.getId() > 0)
		{
			return this.getById(t.getId());
		}
		return this.getByName(t.getName());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Machine> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Machine> machineList = session.createQuery("from Machine").list();
		for(Machine m : machineList){
			logger.info("Machine List:" + m);
		}
		return machineList;
	}

	@Override
	public Machine getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Machine m = (Machine) session.load(Machine.class, new Integer(id));
		logger.info("Machine loaded successfully, machine details=" + m);
		return m;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Machine m = (Machine) session.load(Machine.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Machine deleted successfully, machine details=" + m);
	}
	
	@SuppressWarnings("unchecked")
	private Machine getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(Machine.class);
		cri.add(Restrictions.eq("name", name));
		List<Machine> list = cri.list();
		logger.info("Get Machine info by name successfully, Machine Details=" + list.get(0));
		return list.get(0);
	}

}
