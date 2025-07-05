package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.bookstore.entity.BookOrder;


public class OrderDAO extends JpaDAO<BookOrder> implements GenericDAO<BookOrder> {
	
	public BookOrder create(BookOrder order) {
		order.setOrder_date(new Date());
		order.setStatus("Processing");
		return super.create(order);
	}
	
	public BookOrder update(BookOrder order) {
		return super.update(order);
	}

	@Override
	public BookOrder get(Object orderId) {
		return super.find(BookOrder.class, orderId);
	}
	

	public BookOrder get(Integer orderId, Integer custId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("orderId", orderId);
		parameters.put("custId", custId);
		List<BookOrder> listOrders = super.findWithNamedQuery("bookOrder.findByIdAndCustomer", parameters);
		if(!listOrders.isEmpty()) {
			return listOrders.get(0);
		}
		return null;
	
	}

	@Override
	public void delete(Object orderId) {
		super.delete(BookOrder.class, orderId);
		
	}

	@Override
	public List<BookOrder> listAll() {
		return super.findWithNamedQuery("bookOrder.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("bookOrder.countAll");
	}
	
	public List<BookOrder> listByCustomer(int custId){
		return super.findWithNamedQuery("bookOrder.findByCustomer", "customerId", custId);
	}
	
	

}





