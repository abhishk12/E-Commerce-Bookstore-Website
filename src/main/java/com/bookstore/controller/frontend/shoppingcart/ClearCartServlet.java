package com.bookstore.controller.frontend.shoppingcart;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clear_cart")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClearCartServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.clear();
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
	}

}
