package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.PreorderRecord;

public interface PreorderRecordDAO extends BasicDAO<PreorderRecord> {

	public List<PreorderRecord> listWithCriteria(DetachedCriteria dc);
	
	public void updatePreorderedCapacity(int id, int increment);

}
