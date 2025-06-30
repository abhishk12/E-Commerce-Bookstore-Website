package com.bookstore.dao;

import java.util.Date;
import java.util.List;

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

}
