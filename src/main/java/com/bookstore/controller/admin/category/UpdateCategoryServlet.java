package com.bookstore.controller.admin.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookstore.service.CategoryServices;

@WebServlet("/admin/update_category")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateCategoryServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices categoryServices = new CategoryServices(request, response);
		categoryServices.updateCategory();
	}

}
