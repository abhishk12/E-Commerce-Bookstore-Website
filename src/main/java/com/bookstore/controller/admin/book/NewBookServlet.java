package com.bookstore.controller.admin.book;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/new_book")
public class NewBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public NewBookServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookServices = new BookServices(entityManager, request, response);
		bookServices.showBookCreationForm();
	}

}
