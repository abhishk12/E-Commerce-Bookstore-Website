package com.bookstore.controller.admin.order;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/add_book_to_order")
public class AddBookToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddBookToOrderServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("selected_book_id"));
		int quantity = Integer.parseInt(request.getParameter("selected_number_of_copies"));
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder)session.getAttribute("orderObj");
		
		float subTotal = quantity*book.getPrice();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setBook(book);
		orderDetail.setQuantity(quantity);
		orderDetail.setSub_total(subTotal);
		
		float total = order.getTotal() + subTotal;
		order.setTotal(total);
		session.setAttribute("NewBookAdded", true);
		order.getOrder_details().add(orderDetail);
		request.setAttribute("bookObj", book);
		request.getRequestDispatcher("add_book_result.jsp").forward(request, response);
		
	}

}





