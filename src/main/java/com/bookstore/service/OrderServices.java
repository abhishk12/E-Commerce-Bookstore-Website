package com.bookstore.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bookstore.controller.frontend.shoppingcart.ShoppingCart;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderServices {
	private OrderDAO orderDAO;

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		orderDAO = new OrderDAO();
		this.request = request;
		this.response = response;
	}


	public void listAllOrders(String updateOrderMessage) throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		if(updateOrderMessage!=null) {
			request.setAttribute("updateOrderMessage", updateOrderMessage);
		}
		request.setAttribute("listOrder", listOrder);
		request.setAttribute("pageTitle", "Order Management");
		request.getRequestDispatcher("order_list.jsp").forward(request, response);
		
	}
	
	public void listAllOrders() throws ServletException, IOException {
		listAllOrders(null);
		
	}


	public void viewOrderDetailsForAdmin() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		BookOrder order = orderDAO.get(orderId);
		System.out.println("In viewOrderDetailsForAdmin service - orderId: " + order.getOrder_id());
		request.setAttribute("orderObj", order);
		request.setAttribute("pageTitle", "Order Details");
		request.getRequestDispatcher("order_detail.jsp").forward(request, response);
	}


	public void showCheckOutForm() throws ServletException, IOException {
		request.setAttribute("pageTitle", "Checkout");
		request.getRequestDispatcher("frontend/checkout.jsp").forward(request, response);
		
	}


	public void placeOrder() throws ServletException, IOException {
		String recipient_name = request.getParameter("recipient_name");
		String recipient_phone = request.getParameter("recipient_phone");
		String recipient_street_address = request.getParameter("recipient_street_address");
		String recipient_city = request.getParameter("recipient_city");
		String recipient_zipcode = request.getParameter("recipient_zipcode");
		String recipient_country = request.getParameter("recipient_country");
		String payment_method = request.getParameter("payment_method");
		
		BookOrder order = new BookOrder();
		order.setRecipient_name(recipient_name);
		order.setRecipient_phone(recipient_phone);
		String shippingAddress = recipient_street_address + ", " + recipient_city + ", " + recipient_zipcode + ", " + recipient_country;          
		order.setShipping_address(shippingAddress);
		order.setPayment_method(payment_method);
		
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		Map<Book, Integer> items = shoppingCart.getItems();
		Iterator<Book> iterator  = items.keySet().iterator();
		
		Set<OrderDetail> order_details = new HashSet<OrderDetail>();
		
		while(iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = items.get(book);
			float subTotal = quantity*book.getPrice();
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(book);
			orderDetail.setBookOrder(order);
			orderDetail.setQuantity(quantity);
			orderDetail.setSub_total(subTotal);
			order_details.add(orderDetail);
			
		}
		
		order.setOrder_details(order_details);
		order.setTotal(shoppingCart.getTotalAmount());
		
		orderDAO.create(order);
		
		shoppingCart.clear();
		request.setAttribute("message", "Thank you. Your order has been received.");
		request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
	}


	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		request.setAttribute("pageTitle", "Order History");
		List<BookOrder> orders = orderDAO.listByCustomer(customer.getCustomer_id());
		request.setAttribute("listOrder", orders);
		request.getRequestDispatcher("frontend/order_list.jsp").forward(request, response);
		
	}


	public void showOrderDetailForCustomer() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		BookOrder order = orderDAO.get(orderId, customer.getCustomer_id());
		
		
		request.setAttribute("orderObj", order);
		request.setAttribute("pagetTitle", "My Order Details");
		request.getRequestDispatcher("frontend/order_detail.jsp").forward(request, response);
		
	}


	public void showEditOrderForm() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("order_id"));
		System.out.println("In showEditOrderForm service orderId: " + orderId);
		HttpSession session = request.getSession();
		
		Object flag = session.getAttribute("NewBookAdded");
		if(flag == null) {
			BookOrder order = orderDAO.get(orderId);
			session.setAttribute("orderObj", order);
		}
		else {
			session.removeAttribute("NewBookAdded");
		}
		
		request.setAttribute("pageTitle", "Edit Order");
		request.getRequestDispatcher("order_form.jsp").forward(request, response);
		
	}


	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("orderObj");
		
		String recipient_name = request.getParameter("recipient_name");
		String recipient_phone = request.getParameter("recipient_phone");
		String shipping_address = request.getParameter("shipping_address");
		String payment_method = request.getParameter("payment_method");
		String order_status = request.getParameter("order_status");
		
		order.setRecipient_name(recipient_name);
		order.setRecipient_phone(recipient_phone);
		order.setShipping_address(shipping_address);
		order.setPayment_method(payment_method);
		order.setStatus(order_status);
		
		String[] bookIds = request.getParameterValues("bookId");
		String[] bookPrices = request.getParameterValues("bookPrice");
		String[] quantities = new String[bookIds.length];
		
		for(int i = 0 ; i < quantities.length ; i++) {
			int quantityIndex = i+1;
			quantities[i] = request.getParameter("quantity" + quantityIndex);
		}
		
		Set<OrderDetail> order_details = order.getOrder_details();
		float totalAmount = 0.0f;
		
		order_details.clear();
		for(int i = 0 ; i < bookIds.length ; i++) {
			int bookId = Integer.parseInt(bookIds[i]);
			int book_quantity = Integer.parseInt(quantities[i]);
			float book_price = Float.parseFloat(bookPrices[i]);
			float subTotal = book_price*book_quantity;
			totalAmount += subTotal;
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(new Book(bookId));
			orderDetail.setQuantity(book_quantity);
			orderDetail.setSub_total(subTotal);
			orderDetail.setBookOrder(order);
			
			order_details.add(orderDetail);
			
		}
		
		order.setTotal(totalAmount);
		orderDAO.update(order);

		listAllOrders("Order updated successfully!");
		
		
	}


	public void deleteOrder() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		orderDAO.delete(orderId);
		listAllOrders("Order ID: " + orderId+ " deleted successfully!");
		
	}

}








