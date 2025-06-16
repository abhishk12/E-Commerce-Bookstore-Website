package com.bookstore.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookstore.service.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateUserServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("user_email");
		String fullName = request.getParameter("user_full_name");
		String password = request.getParameter("user_password");
		
		UserServices userServices = new UserServices();
		userServices.createUser(email, fullName, password);
		
		response.getWriter().println("Email: " + email + "\nFull Name: " + fullName + "\nPassword: " + password);
	}

}
