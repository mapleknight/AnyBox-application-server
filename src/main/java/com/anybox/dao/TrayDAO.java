package com.anybox.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anybox.model.Tray;

public interface TrayDAO extends BasicDAO<Tray> {
	
	public List<Tray> listWithCriteria(DetachedCriteria dc);

}
