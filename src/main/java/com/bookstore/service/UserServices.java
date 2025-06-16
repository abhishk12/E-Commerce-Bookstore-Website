package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserServices {
	private UserDAO userDAO;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	
	public UserServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}



	public List<Users> listUser() {
		List<Users> listUsers = userDAO.listAll();
		System.out.println(listUsers.size());
		return listUsers;
	}
	
	public void createUser(String email, String fullName, String password) {
		Users user = new Users(email, fullName, password);
		userDAO.create(user);
	}
	
}
