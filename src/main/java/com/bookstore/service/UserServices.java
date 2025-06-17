package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServices {
	private UserDAO userDAO;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
		this.request = request;
		this.response = response;
	}

	
	public void listUser() throws ServletException, IOException{
		
		listUser(null);
	}

	public void listUser( String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("pageTitle", "Manage Users");
		if(message!=null) {
			request.setAttribute("newUserMessage", message);
		}
		request.getRequestDispatcher("user_list.jsp").forward(request, response);
		return;
	}
	
	public void createUser() throws ServletException, IOException{
		
		String email = request.getParameter("user_email");
		String fullName = request.getParameter("user_full_name");
		String password = request.getParameter("user_password");
		
		Users user_exists = userDAO.findByEmail(email);
		if(user_exists!=null) {
			String message = "User already exists!";
			request.setAttribute("newUserMessage", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		else {
			Users user = new Users(email, fullName, password);
			userDAO.create(user);
		}

		
	}
	
	public void editUser() throws ServletException, IOException {
		Integer userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId);
		request.setAttribute("userObj", user);
		request.getRequestDispatcher("user_form.jsp").forward(request, response);
	}
	
	public void updateUser() throws ServletException, IOException{
		String email = request.getParameter("user_email");
		String fullName = request.getParameter("user_full_name");
		String password = request.getParameter("user_password");
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		Users currUser = userDAO.get(userId);
		Users someUser = userDAO.findByEmail(email);
		
		if((someUser!=null) && (currUser.getUser_id() != someUser.getUser_id())) {
			request.setAttribute("newUserMessage", "Could not update user. User with email already exists!");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		else {
			Users user = new Users(userId, email, fullName, password);
			userDAO.update(user);
			listUser("User has been updated successfully!");
		}
		
		
	}
	
}
