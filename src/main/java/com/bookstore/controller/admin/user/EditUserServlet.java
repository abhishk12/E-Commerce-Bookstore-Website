package com.bookstore.controller.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserServices;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userServices = new UserServices(entityManager, request, response);
		userServices.editUser();
	}


}
