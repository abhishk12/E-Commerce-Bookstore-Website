package com.bookstore.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}
	@Override
	public void destroy(){
		entityManagerFactory.close();
		entityManagerFactory.close();
	}
	
       
	
}
