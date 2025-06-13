package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class UserDAOTest {

	@Test
	void testCreateUsers() {
		Users user = new Users();
		user.setEmail("pqr@gmail.com");
		user.setFull_name("PQR");
		user.setPassword("789");
 		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//		entityManager.getTransaction().begin();
//		entityManager.persist(user);
//		
//		entityManager.getTransaction().commit();
		
		UserDAO userDAO = new UserDAO(entityManager);
		user = userDAO.create(user);
		
		entityManager.close();
		entityManagerFactory.close();
		
		assertTrue(user.getUser_id()>0);
	}
	
	@Test
	public void testUpdateUsers() {
		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Users user = new Users();
		user.setUser_id(19);
		user.setEmail("abc@gmail.com");
		user.setFull_name("ABC");
		user.setPassword("124");
		
		UserDAO userDAO = new UserDAO(entityManager);
		user = userDAO.update(user);
		
		entityManager.close();
		entityManagerFactory.close();
		
		String expected = "124";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}

}
