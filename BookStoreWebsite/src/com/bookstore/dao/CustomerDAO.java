package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Customer;
import com.bookstore.entity.Users;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	@Override
	public Customer create(Customer customer) {
		return super.create(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return super.update(customer);
	}

	@Override
	public Customer get(Object id) {
		return super.get(Customer.class, id);
	}

	@Override
	public Customer delete(Object id) {
		return super.delete(Customer.class, id);
	}

	@Override
	public List<Customer> listAll() {
		return super.findWithNamedQuery("Customer.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Customer.countAll");
	}
	
	public Customer findByEmail(String email) {
		List<Customer> listCustomers = super.findWithNamedQuery("Customer.findByEmail", "email", email);
		
		if (listCustomers != null && listCustomers.size() > 0) {
			return listCustomers.get(0);
		}
		return null;
	}

}