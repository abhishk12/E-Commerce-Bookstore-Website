package com.bookstore.controller.admin.book;

import com.bookstore.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024*10,
		maxFileSize = 1024*300,
		maxRequestSize = 1024*1024
)
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateBookServlet() {
 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookServices = new BookServices( request, response);
		bookServices.createBook();
	}

}
