package com.anybox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anybox.dao.MachineDAO;
import com.anybox.model.Machine;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired(required=true)
	@Qualifier(value="machineDAO")
	private MachineDAO machineDAO;
	
	@Override
	public Machine add(Machine t) {
		return this.machineDAO.add(t);
	}

	@Override
	public Machine update(Machine t) {
		return this.machineDAO.update(t);
	}

	@Override
	public List<Machine> list() {
		return this.machineDAO.list();
	}

	@Override
	public Machine getById(int id) {
		return this.machineDAO.getById(id);
	}

	@Override
	public void delete(int id) {
		this.machineDAO.delete(id);
	}

}
