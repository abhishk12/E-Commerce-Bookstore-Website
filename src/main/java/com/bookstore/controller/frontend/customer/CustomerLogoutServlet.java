package com.bookstore.controller.frontend.customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class CustomerLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CustomerLogoutServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("loggedCustomer");
		response.sendRedirect(request.getContextPath() + "/home");
	}

}
