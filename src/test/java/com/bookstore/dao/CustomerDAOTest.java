package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Customer;

class CustomerDAOTest {
	private static CustomerDAO customerDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	void testGet() {
		Customer customer = customerDAO.get(11);
		assertNotNull(customer);
		
	}

	@Test
	void testDeleteObject() {
		customerDAO.delete(11);
		
		Customer customer = customerDAO.get(11);
		assertNull(customer); 
	}

	
	@Test
	void testUpdateCustomer() {
		Customer existingCustomer = customerDAO.get(11);
		String new_full_name = "Tom Tom";
		existingCustomer.setFull_name(new_full_name);
		Customer updatedCustomer = customerDAO.update(existingCustomer);
		assertTrue(updatedCustomer.getFull_name().equals(new_full_name));
	}

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("tom@gmail.com");
		customer.setFull_name("Tom Eager");
		customer.setCity("New York");
		customer.setCountry("USA");
		customer.setAddress("100 North Avenue");
		customer.setPassword("123");
		customer.setPhone("123214");
		customer.setZip_code("80302");
		
		Customer newCustomer = customerDAO.create(customer);
		assertTrue(newCustomer.getCustomer_id()>0);
	}
	
	@Test
	void testListAllCustomer() {
		List<Customer> listCustomer = customerDAO.listAll();
		
		for(Customer cust: listCustomer) {
			System.out.println(cust.getEmail());
		}
		
		assertEquals(listCustomer.size(), 2);
	}
	
	@Test
	void testCountAllCustomer() {
		long cnt = customerDAO.count();
		assertEquals(cnt, 2);
//		assertEquals(listCustomer.size(), 2);
	}
	
	@Test
	void testFindByEmail() {
		Customer cust = customerDAO.findByEmail("cat@gmai.com");
		assertNotNull(cust);
	}

}
