package com.bookstore.controller.admin.order;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/remove_book_from_order")
public class RemoveBookFromOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveBookFromOrderServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder)session.getAttribute("orderObj");
		
		Set<OrderDetail> orderDetails = order.getOrder_details();
		Iterator<OrderDetail> iterator = orderDetails.iterator();
		while(iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if(orderDetail.getBook().getBook_id() == bookId) {
				float newTotal = order.getTotal() - orderDetail.getSub_total();
				order.setTotal(newTotal);
				iterator.remove();
			}
		}
		
		request.getRequestDispatcher("order_form.jsp").forward(request, response);
	}

}









