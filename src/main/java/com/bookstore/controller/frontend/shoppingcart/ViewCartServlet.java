package com.bookstore.controller.frontend.shoppingcart;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view_cart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewCartServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object cartObject = request.getSession().getAttribute("cart");
		if(cartObject==null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
//			BookDAO bookDAO = new BookDAO();
//			Book book1 = bookDAO.get(34);
//			Book book2 = bookDAO.get(35);
//			Book book3 = bookDAO.get(33);
//			Book book4 = bookDAO.get(37);
//			Book book5 = bookDAO.get(38);
//			Book book6 = bookDAO.get(39);
//			Book book7 = bookDAO.get(40);
//			shoppingCart.addItem(book1);
//			shoppingCart.addItem(book2);
//			shoppingCart.addItem(book2);
//			shoppingCart.addItem(book2);
//			shoppingCart.addItem(book3);
//			shoppingCart.addItem(book3);
//			shoppingCart.addItem(book4);
//			shoppingCart.addItem(book5);
//			shoppingCart.addItem(book5);
//			shoppingCart.addItem(book5);
//			shoppingCart.addItem(book5);
//			shoppingCart.addItem(book6);
//			shoppingCart.addItem(book7);
//			shoppingCart.addItem(book7);
//			shoppingCart.addItem(book7);
		}
		
		
		
		request.setAttribute("pageTitle", "Your cart");
		request.getRequestDispatcher("frontend/shopping_cart.jsp").forward(request, response);
	}

}
