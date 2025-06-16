package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class UserDAOTest {

	@Test
	void testCreateUsers() {
		Users user = new Users();
		user.setEmail("bwada@gmail.com");
		user.setFull_name("Batata Wada");
		user.setPassword("qwertyui");
 		
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
		user.setPassword("123");
		
		UserDAO userDAO = new UserDAO(entityManager);
		user = userDAO.update(user);
		
		entityManager.close();
		entityManagerFactory.close();
		
		String expected = "123";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entityManager);
		Users user = userDAO.get(22);
		System.out.println(user.getEmail());
		entityManager.close();
		entityManagerFactory.close();
		assertNotNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entityManager);
		userDAO.delete(19);
		Users user = userDAO.get(19);
		entityManager.close();
		entityManagerFactory.close();
		assertNull(user);
	}
	
	@Test
	public void testListAllUsers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entityManager);
		List<Users> userList = userDAO.listAll(); 
		for(Users user:userList) {
			System.out.println(user.getEmail());
		}
		System.out.println(userList.size());
		entityManager.close();
		entityManagerFactory.close();
		assertTrue(userList.size()>0);
	}
	
	@Test
	public void testCountAllUsers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entityManager);
		long cnt = userDAO.count(); 
		System.out.println(cnt);
		entityManager.close();
		entityManagerFactory.close();
		assertTrue(cnt==2);
	}
	
	@Test
	public void testFindByEmail() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserDAO userDAO = new UserDAO(entityManager);
		Users user = userDAO.findByEmail("abc@gmail.com"); 
		System.out.println(user.getUser_id());
		entityManager.close();
		entityManagerFactory.close();
		assertNotNull(user);
	}
	
}
