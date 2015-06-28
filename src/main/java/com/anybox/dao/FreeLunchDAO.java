package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.FreeLunch;

public interface FreeLunchDAO extends BasicDAO<FreeLunch> {

	List<FreeLunch> listWithCriteria(DetachedCriteria dc);

}
