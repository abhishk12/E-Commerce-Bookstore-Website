package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.swing.plaf.ListUI;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerServices {
	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		customerDAO = new CustomerDAO();
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}
	
	public void listCustomers(String message) throws ServletException, IOException {
		List<Customer> listCustomers = customerDAO.listAll();
		if(message!=null) {
			request.setAttribute("newCustomerMessage", message);
		}

		request.setAttribute("pageTitle", "Manage Customers");
		request.setAttribute("listCustomer", listCustomers);
		request.getRequestDispatcher("customer_list.jsp").forward(request, response);
	}

	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("customer_email");
		Customer existCustomer = customerDAO.findByEmail(email);
		
		if(existCustomer!=null) {
			listCustomers("Could not create customer. Email already exist!");
		}
		else {
			String customer_full_name = request.getParameter("customer_full_name");
			String customer_password = request.getParameter("customer_password");
			String customer_address = request.getParameter("customer_address");
			String customer_zipcode = request.getParameter("customer_zipcode");
			String customer_city = request.getParameter("customer_city");
			String customer_country = request.getParameter("customer_country");
			String customer_phone = request.getParameter("customer_phone");
			Customer newCustomer = new Customer();
			newCustomer.setEmail(email);
			newCustomer.setFull_name(customer_full_name);
			newCustomer.setPassword(customer_password);
			newCustomer.setAddress(customer_address);
			newCustomer.setZip_code(customer_zipcode);
			newCustomer.setCity(customer_city);
			newCustomer.setCountry(customer_country);
			newCustomer.setPhone(customer_phone);
			
			customerDAO.create(newCustomer);
			listCustomers("Customer created successfully!");
		}
	}

	public void editCustomer() throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDAO.get(customerId);
		request.setAttribute("custObj", existingCustomer);
		request.getRequestDispatcher("customer_form.jsp").forward(request, response);
		
	}

	public void updateCustomer() throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customer_id"));
		String email = request.getParameter("customer_email");
		Customer existingCustomer = customerDAO.findByEmail(email);
		
		if((existingCustomer!=null) && (existingCustomer.getCustomer_id()!= customerId)) {
			listCustomers("Could not update customer. Email already exists!");
		}
		else {
			String customer_full_name = request.getParameter("customer_full_name");
			String customer_password = request.getParameter("customer_password");
			String customer_address = request.getParameter("customer_address");
			String customer_zipcode = request.getParameter("customer_zipcode");
			String customer_city = request.getParameter("customer_city");
			String customer_country = request.getParameter("customer_country");
			String customer_phone = request.getParameter("customer_phone");
			
			Customer customerById = customerDAO.get(customerId);
			customerById.setEmail(email);
			customerById.setFull_name(customer_full_name);
			customerById.setPassword(customer_password);
			customerById.setAddress(customer_address);
			customerById.setZip_code(customer_zipcode);
			customerById.setCity(customer_city);
			customerById.setCountry(customer_country);
			customerById.setPhone(customer_phone);
			
			customerDAO.update(customerById);
			listCustomers("Customer updated successfully!");
		}
	}

	public void deleteCustomer() throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(customerId);
		listCustomers("Customer deleted successfully");
		
	}
}
