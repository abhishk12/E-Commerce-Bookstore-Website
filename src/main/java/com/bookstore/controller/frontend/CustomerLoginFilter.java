package com.bookstore.controller.frontend;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mysql.cj.Session;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@WebFilter("/*")
public class CustomerLoginFilter extends HttpFilter {
	
	private static final String[] loginRequiredURLs = {"/view_profile", "/edit_profile",
			"/update_profile"};
       
    public CustomerLoginFilter() {
        super();

    }
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession(false);
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if(path.equals("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		
		boolean loggedIn = (session!= null) && (session.getAttribute("loggedCustomer")!= null);
		String requestURL = httpRequest.getRequestURL().toString();
		System.out.println(requestURL);
		
		if(!loggedIn && isLoginRequired(requestURL)) {
			request.getRequestDispatcher("frontend/login.jsp").forward(httpRequest, response);
		}
		else {
			chain.doFilter(request, response);
		}
		
	}
	
	private boolean isLoginRequired(String requestURL) {
		for(String loginRequiredURL: loginRequiredURLs) {
			if(requestURL.contains(loginRequiredURL)) {
				return true;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
