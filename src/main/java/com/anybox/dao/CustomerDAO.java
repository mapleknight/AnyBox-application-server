package com.anybox.dao;

import java.util.List;

import com.anybox.model.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
}
