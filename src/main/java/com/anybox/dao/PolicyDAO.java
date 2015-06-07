package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.Policy;

public interface PolicyDAO extends BasicDAO<Policy> {
	
	List<Policy> listWithCriteria(DetachedCriteria dc);

}
