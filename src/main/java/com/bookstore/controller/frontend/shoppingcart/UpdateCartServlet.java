package com.bookstore.controller.frontend.shoppingcart;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update_cart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCartServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bookIds = request.getParameterValues("book_id");
		String[] quantities = new String[bookIds.length];
		
		for(int i = 0 ; i < bookIds.length ; i++) {
			int quantityNumber = i+1;
			String quantity= request.getParameter("quantity" + quantityNumber);
			quantities[i] = quantity;
		}

		int[] bookIdsInt = Arrays.stream(bookIds).mapToInt(Integer::parseInt).toArray();
		int[] quantitiesInt = Arrays.stream(quantities).mapToInt(Integer::parseInt).toArray();
		
		ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
		cart.updateCart(bookIdsInt, quantitiesInt);
		
		String redirectURL = request.getContextPath().concat("/view_cart");
		response.sendRedirect(redirectURL);
		
		
		
	}

}
