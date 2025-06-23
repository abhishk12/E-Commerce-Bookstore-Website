package com.bookstore.controller.frontend;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		List<Book> newBooks = bookDAO.listNewBooks();
		request.setAttribute("listNewBooks", newBooks);
		
//		CategoryDAO categoryDAO = new CategoryDAO();
//		List<Category> listCategories = categoryDAO.listAll();
//		request.setAttribute("listCategory", listCategories);
		request.setAttribute("pageTitle", "The Book Nook - An Online Bookstore");
		request.getRequestDispatcher("frontend/index.jsp").forward(request, response);
	}

}
