package com.bookstore.controller.admin.user;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.entity.Users;
import com.bookstore.service.UserServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/list_users")
public class ListUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ListUserServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userServices = new UserServices(entityManager, request, response);
		userServices.listUser(null);
		
	}

}
