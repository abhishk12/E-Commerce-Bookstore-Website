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
import jakarta.servlet.http.HttpSession;

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
	
	private void updateCustomerFieldsFromForm(Customer customer) {
		String email = request.getParameter("customer_email");
		String customer_full_name = request.getParameter("customer_full_name");
		String customer_password = request.getParameter("customer_password");
		String customer_address = request.getParameter("customer_address");
		String customer_zipcode = request.getParameter("customer_zipcode");
		String customer_city = request.getParameter("customer_city");
		String customer_country = request.getParameter("customer_country");
		String customer_phone = request.getParameter("customer_phone");
		
		if((email!=null) && (!email.equals(""))) {
			customer.setEmail(email);
		}
		
		customer.setFull_name(customer_full_name);
		
		if((customer_password!=null) && (!customer_password.equals("")) ) {
			customer.setPassword(customer_password);
		}

		customer.setAddress(customer_address);
		customer.setZip_code(customer_zipcode);
		customer.setCity(customer_city);
		customer.setCountry(customer_country);
		customer.setPhone(customer_phone);
	}
	
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("customer_email");
		Customer existCustomer = customerDAO.findByEmail(email);
		
		if(existCustomer!=null) {
			listCustomers("Could not create customer. Email already exist!");
		}
		else {
			
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);
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

			
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsFromForm(customerById);
			
			customerDAO.update(customerById);
			listCustomers("Customer updated successfully!");
		}
	}

	public void deleteCustomer() throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(customerId);
		listCustomers("Customer deleted successfully");
		
	}
	
	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("customer_email");
		Customer existCustomer = customerDAO.findByEmail(email);
		String message = "";
		if(existCustomer!=null) {
			message = "Could not register. Email already exist!";
		}
		else {
			
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);
			customerDAO.create(newCustomer);
			message = "You have registered successfully! Thank you.";
			
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
	}

	public void showLogin(String message) throws ServletException, IOException {
		request.setAttribute("message", message);
		request.setAttribute("pageTitle", "Customer Login");
		request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
		
	}
	
	public void showLogin() throws ServletException, IOException {
		showLogin(null);
		
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("cust_email");
		String password = request.getParameter("cust_password");
		Customer customer = customerDAO.checkLogin(email, password);
		if(customer == null) {
			showLogin("Login Failed! Please check your email and password.");
		}
		else {
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			Object objRedirectURL = session.getAttribute("redirectURL");
			String redirectURL = "";
			if(objRedirectURL!=null) {
				redirectURL = (String) objRedirectURL;
				session.removeAttribute("redirectURL");
				response.sendRedirect(redirectURL);
			}
			else {
				
				request.setAttribute("message", "Logged in successfully!");
				showCustomerProfile();
			}
			
		}
		
	}
	
	public void showCustomerProfile(String message) throws ServletException, IOException {
		
		if(message!=null) {
			request.setAttribute("message", "Logged in successfully!");
		}
		
		request.getRequestDispatcher("frontend/customer_profile.jsp").forward(request, response);
	
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		showCustomerProfile(null);
	
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		request.setAttribute("pageTitle", "Edit Profile");
		request.getRequestDispatcher("frontend/edit_profile.jsp").forward(request, response);
		
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		customerDAO.update(customer);
		request.setAttribute("update_message", "Profile updated successfully!");
		showCustomerProfile();
	}
}
