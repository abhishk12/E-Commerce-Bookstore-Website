package com.bookstore.controller.frontend;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		List<Category> listCategories = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategories);
		request.getRequestDispatcher("frontend/index.jsp").forward(request, response);
	}

}
