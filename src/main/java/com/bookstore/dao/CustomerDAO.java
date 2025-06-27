package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Customer;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	@Override
	public Customer get(Object id) {
		return super.find(Customer.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Customer.class, id);
	}
	
	@Override
	public Customer update(Customer customer) {
		return super.update(customer);
	}

	@Override
	public List<Customer> listAll() {
		return super.findWithNamedQuery("customer.findAll");
	}

	@Override
	public long count() {
		long cnt = super.countWithNamedQuery("customer.countAll");
		return cnt;
	}

	public Customer create(Customer customer) {
		customer.setRegister_date(new Date());
		return super.create(customer);
	}
	
	public Customer findByEmail(String email) {
		List<Customer> listCustomer = super.findWithNamedQuery("customer.findByEmail", "email", email);
		if(!listCustomer.isEmpty()) {
			return listCustomer.get(0);
		}
		return null;	
	}
	
	public Customer checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		List<Customer> listCustomers = super.findWithNamedQuery("customer.checkLogin", parameters);
		
		if(!listCustomers.isEmpty()) {
			return listCustomers.get(0);
		}
		
		return null;
	}

}
