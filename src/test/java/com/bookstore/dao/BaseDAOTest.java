package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseDAOTest {
	
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;

	static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}

	static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}

}
