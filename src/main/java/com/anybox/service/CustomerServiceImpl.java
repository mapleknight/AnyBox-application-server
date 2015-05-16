package com.anybox.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.CustomerDAO;
import com.anybox.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void addCustomer(Customer c) {
		this.customerDAO.addCustomer(c);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		this.customerDAO.updateCustomer(c);
	}

	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

}
