package com.bookstore.controller.admin;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mysql.cj.Session;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {
       
    public AdminLoginFilter() {
        super();

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		boolean flag = (session!=null) && (session.getAttribute("userEmail")!=null);
		String loginURI = httpRequest.getContextPath() + "/admin/login";
		boolean passFlag = httpRequest.getRequestURI().equals(loginURI);
		boolean passLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		if(flag && (passFlag || passLoginPage)) {
			request.getRequestDispatcher("/admin/").forward(request, response);
		}
		
		if(flag || passFlag) {
			chain.doFilter(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
