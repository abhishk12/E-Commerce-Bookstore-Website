package com.bookstore.controller.admin.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookstore.service.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateUserServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userServices = new UserServices(request, response);
		userServices.createUser();
//		userServices.listUser();
	}

}
