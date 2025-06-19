package com.bookstore.controller.admin;

import com.bookstore.controller.BaseServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/logout")
public class AdminLogoutServlet extends BaseServlet {
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
