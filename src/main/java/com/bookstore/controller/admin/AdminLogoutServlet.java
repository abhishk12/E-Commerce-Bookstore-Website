package com.bookstore.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/logout")
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLogoutServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("userEmail");
		request.setAttribute("message", "Logged out successfully!");
		request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
	}

}
