package com.anybox.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anybox.model.PreorderRecord;

@Repository
public class PreorderRecordDAOImpl implements PreorderRecordDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PreorderRecordDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public PreorderRecord add(PreorderRecord t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		logger.info("Add PreorderRecord successfully, PreorderRecord Details=" + t);
		return t;
	}

	@Override
	public PreorderRecord update(PreorderRecord t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Update PreorderRecord successfully, PreorderRecord Details=" + t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PreorderRecord> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<PreorderRecord> preorderRecordList = session.createQuery("from Preorder_record").list();
		for(PreorderRecord o : preorderRecordList){
			logger.info("PreorderRecord List:" + o);
		}
		return preorderRecordList;
	}

	@Override
	public PreorderRecord getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		PreorderRecord o = (PreorderRecord) session.load(PreorderRecord.class, new Integer(id));
		logger.info("PreorderRecord loaded successfully, PreorderRecord details=" + o);
		return o;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PreorderRecord o = (PreorderRecord) session.load(PreorderRecord.class, new Integer(id));
		if(null != o){
			session.delete(o);
		}
		logger.info("PreorderRecord deleted successfully, PreorderRecord details=" + o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PreorderRecord> listWithCriteria(DetachedCriteria dc) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cri = dc.getExecutableCriteria(session);
		List<PreorderRecord> list = cri.list();

		return list;
	}
	
	@Override
	public void updatePreorderedCapacity(int id, int increment) {
		Session session = this.sessionFactory.getCurrentSession();
		// UPDATE `anybox`.`Preorder_record` SET `preorder_capacity`=`preorder_capacity`+ increment 
		// WHERE `id`=?
		String sql = "update Preorder_record set preorder_capacity=preorder_capacity + ? where id=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setInteger(0, increment);
		query.setInteger(1, id);
		query.executeUpdate();
	}

}
