package com.anybox.dao;

import java.util.List;

import com.anybox.model.Tray;

public interface TrayDAO {
	
	public Tray add(Tray t);
	public Tray update(Tray t);
	public List<Tray> list();
	public Tray getById(int id);
	public void delete(int id);

}
