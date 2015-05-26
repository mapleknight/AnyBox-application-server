package com.anybox.dao;

import java.util.List;

import com.anybox.model.Machine;

public interface MachineDAO {
	
	public Machine add(Machine t);
	public Machine update(Machine t);
	public List<Machine> list();
	public Machine getById(int id);
	public void delete(int id);

}
