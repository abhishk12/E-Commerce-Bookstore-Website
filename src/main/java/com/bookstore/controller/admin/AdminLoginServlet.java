package com.bookstore.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookstore.service.UserServices;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLoginServlet() {
        super();

    }
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserServices userServices = new UserServices(request, response);
		userServices.login();
		
	}

}
