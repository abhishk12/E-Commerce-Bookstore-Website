package com.bookstore.controller.admin.book;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,
		maxFileSize = 1024*300,
		maxRequestSize = 1024*1024
)
public class UpdateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public UpdateBookServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookServices = new BookServices(entityManager, request, response);
		bookServices.updateBook();
	}

}
