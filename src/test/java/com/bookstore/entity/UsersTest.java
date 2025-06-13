package com.bookstore.entity;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsersTest {

	public static void main(String[] args) {
		
		Users user = new Users();
		user.setEmail("abc@gmail.com");
		user.setFull_name("ABC");
		user.setPassword("123");
 		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("User object was persisted!");
		
	}

}
