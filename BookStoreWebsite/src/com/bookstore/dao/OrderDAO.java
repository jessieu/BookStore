package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;

public class OrderDAO extends JpaDAO<BookOrder> implements GenericDAO<BookOrder> {

	@Override
	public BookOrder create(BookOrder order) {
		order.setOrderDate(new Date());
		return super.create(order);
	}
	
	@Override
	public BookOrder update(BookOrder order) {
		return super.update(order);
	}
	
	@Override
	public BookOrder get(Object orderId) {
		return super.get(BookOrder.class, orderId);
	}
	
	public BookOrder get(Integer orderId, Integer customerId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("orderId", orderId);
		parameters.put("customerId", customerId);
		List<BookOrder> result = super.findWithNamedQuery("BookOrder.findByIdAdCustomer", parameters);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}

	@Override
	public BookOrder delete(Object id) {
		return super.delete(BookOrder.class, id);
	}

	@Override
	public List<BookOrder> listAll() {
		return super.findWithNamedQuery("BookOrder.findAll");
	}

	@Override
	public long count() {
		long count = super.countWithNamedQuery("BookOrder.countAll");
		return count;
	}
	
	public List<BookOrder> listByCustomer(Integer customerId) {
		
		return super.findWithNamedQuery("BookOrder.findByCustomer", "customerId", customerId);
	}

}