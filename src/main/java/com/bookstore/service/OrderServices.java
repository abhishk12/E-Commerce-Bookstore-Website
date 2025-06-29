package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.BookOrder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderServices {
	private OrderDAO orderDAO;

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		orderDAO = new OrderDAO();
		this.request = request;
		this.response = response;
	}


	public void listAllOrders() throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		request.setAttribute("listOrder", listOrder);
		request.setAttribute("pageTitle", "Order Management");
		request.getRequestDispatcher("order_list.jsp").forward(request, response);
		
	}


	public void viewOrderDetailsForAdmin() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		BookOrder order = orderDAO.get(orderId);
		request.setAttribute("orderObj", order);
		request.setAttribute("pageTitle", "Order Details");
		request.getRequestDispatcher("order_detail.jsp").forward(request, response);
	}
	
	
	

}
