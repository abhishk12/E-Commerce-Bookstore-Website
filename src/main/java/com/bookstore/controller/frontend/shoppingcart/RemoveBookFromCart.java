package com.bookstore.controller.frontend.shoppingcart;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/remove_from_cart")
public class RemoveBookFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveBookFromCart() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = (ShoppingCart) cartObject;
		
		shoppingCart.removeItem(new Book(bookId));
		
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
		
	}

}
