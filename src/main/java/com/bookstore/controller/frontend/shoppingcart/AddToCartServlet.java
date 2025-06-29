package com.bookstore.controller.frontend.shoppingcart;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		
		Object cartObject = request.getSession().getAttribute("cart");
		ShoppingCart shoppingCart = null;
		if((cartObject!=null) && (cartObject instanceof ShoppingCart)) {
			shoppingCart = (ShoppingCart) cartObject;
		}
		else {
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		
		shoppingCart.addItem(book);
		
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
		
	}

}
