package com.anybox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.TrayDAO;
import com.anybox.model.Tray;

@Service
public class TrayServiceImpl implements TrayService{

	@Autowired(required=true)
	@Qualifier(value="trayDAO")
	private TrayDAO trayDAO;
	
	@Override
	@Transactional
	public Tray add(Tray t) {
		return this.trayDAO.add(t);
	}

	@Override
	@Transactional
	public Tray update(Tray t) {
		return this.trayDAO.update(t);
	}

	@Override
	@Transactional
	public List<Tray> list() {
		return this.trayDAO.list();
	}

	@Override
	@Transactional
	public Tray getById(int id) {
		return this.trayDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.trayDAO.delete(id);
	}

}
