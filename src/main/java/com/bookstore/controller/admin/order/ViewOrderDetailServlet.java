package com.bookstore.controller.admin.order;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.service.OrderServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/view_order")
public class ViewOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewOrderDetailServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServices orderServices = new OrderServices(request, response);
		orderServices.viewOrderDetailsForAdmin();
	}

}
