package com.anybox.dao;

import java.util.List;

import com.anybox.model.Inventory;


public interface InventoryDAO {
	
	public Inventory add(Inventory t);
	public Inventory update(Inventory t);
	public List<Inventory> list();
	public Inventory getById(int id);
	public void delete(int id);

}
