package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import com.bookstore.entity.OrderDetailId;

class OrderDAOTest {
	private static OrderDAO orderDAO;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		orderDAO = new OrderDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		orderDAO.close();
	}

	@Test
	void testCreateBookOrder() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomer_id(17);
		order.setCustomer(customer);
		order.setRecipient_name("Abhishek");
		order.setRecipient_phone("123456789");
		order.setStatus("Processing");
		order.setShipping_address("Chintamani Swaroop, Ambegaon Bk, Pune, Maharashtra, India");
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		OrderDetail orderDetail = new OrderDetail();
		
		Book book = new Book(33);
		orderDetail.setBook(book);
		orderDetail.setQuantity(2);
		orderDetail.setSub_total(688.00f);
		orderDetail.setBookOrder(order);
		orderDetails.add(orderDetail);
		order.setOrder_details(orderDetails);
		
		BookOrder newOrder = orderDAO.create(order);
		assertNotNull(newOrder);
		
	}
	
	@Test
	void testCreateBookOrderMultipleBooks() {
		BookOrder order = new BookOrder();
		Customer customer = new Customer();
		customer.setCustomer_id(21);
		order.setCustomer(customer);
		order.setRecipient_name("Aishwarya");
		order.setRecipient_phone("987654321");
		order.setShipping_address("80302, Boulder, Colorado, USA");
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		OrderDetail orderDetail1 = new OrderDetail();
		
		Book book1 = new Book(34);
		orderDetail1.setBook(book1);
		orderDetail1.setQuantity(3);
		orderDetail1.setSub_total(1125.00f);
		orderDetail1.setBookOrder(order);
		orderDetails.add(orderDetail1);
		
		OrderDetail orderDetail2 = new OrderDetail();
		Book book2 = new Book(37);
		orderDetail2.setBook(book2);
		orderDetail2.setQuantity(2);
		orderDetail2.setSub_total(539.60f);
		orderDetail2.setBookOrder(order);
		orderDetails.add(orderDetail2);
		
		order.setOrder_details(orderDetails);
		
		BookOrder newOrder = orderDAO.create(order);
		assertTrue((newOrder.getOrder_id()>0) && (order.getOrder_details().size()==2));
		
	}

	@Test
	void testUpdateBookOrder() {
		BookOrder order = orderDAO.get(25);
		order.setTotal(1664.60f);
		
		BookOrder updatedOrder = orderDAO.update(order);
		assertEquals(order.getTotal(), updatedOrder.getTotal());
	}
	
	@Test
	void testGet() {
		BookOrder order = orderDAO.get(25);
		assertEquals(2, order.getOrder_details().size());
	}

	@Test
	void testDeleteObject() {
		orderDAO.delete(24);
		BookOrder order = orderDAO.get(24);
		assertNull(order);
	}

	@Test
	void testListAll() {
		List<BookOrder> listOrder = orderDAO.listAll();
		assertEquals(2, listOrder.size());
	}

	@Test
	void testCount() {
		long cnt = orderDAO.count();
		assertEquals(2, cnt);
	}

}
