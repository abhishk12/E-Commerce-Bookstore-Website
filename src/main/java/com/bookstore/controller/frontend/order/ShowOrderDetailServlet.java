package com.bookstore.controller.frontend.order;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.service.OrderServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view_order")
public class ShowOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowOrderDetailServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServices orderServices = new OrderServices(request, response);
		orderServices.showOrderDetailForCustomer();
	}

}
