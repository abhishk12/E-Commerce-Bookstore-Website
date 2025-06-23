package com.bookstore.controller.admin.category;


import com.bookstore.service.CategoryServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCategoryServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryServices categoryServices = new CategoryServices(request, response);
		categoryServices.deleteCategory();
	}

}
