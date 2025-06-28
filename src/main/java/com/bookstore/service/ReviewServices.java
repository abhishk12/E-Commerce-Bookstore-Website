package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReviewServices {
	private ReviewDAO reviewDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		reviewDAO = new ReviewDAO();
	}

	public void listAllReviews(String reviewMessage) throws ServletException, IOException {
		List<Review> listReviews = reviewDAO.listAll();
		
		if(reviewMessage!=null) {
			request.setAttribute("reviewMessage", reviewMessage);
		}
		request.setAttribute("pageTitle", "Review Management");
		request.setAttribute("listReviews", listReviews);
		request.getRequestDispatcher("review_list.jsp").forward(request, response);
		
	}
	
	public void listAllReviews() throws ServletException, IOException {
		listAllReviews(null);
		
	}

	public void editReview() throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("id"));
		Review review = reviewDAO.get(reviewId);
		request.setAttribute("reviewObj", review);
		request.getRequestDispatcher("review_form.jsp").forward(request, response);
		
	}

	public void updateReview() throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("review_id"));
		Review reviewById = reviewDAO.get(reviewId);
		String headline = request.getParameter("review_headline");
		String comment = request.getParameter("review_comment");
		
		reviewById.setHeadline(headline);
		reviewById.setComment(comment);
		reviewDAO.update(reviewById);
		listAllReviews("Review updated successfully!");
	}

	public void deleteReview() throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("id"));
		reviewDAO.delete(reviewId);
		listAllReviews("Review deleted successfully!");
		
	}

	public void showReviewForm() throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		HttpSession session = request.getSession();
		session.setAttribute("bookDetail", book);
//		request.setAttribute("bookDetail", book);
		
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		Review existingReview = reviewDAO.findByCustomerAndBook(customer.getCustomer_id(), bookId);
		if(existingReview!=null) {
			request.setAttribute("message", "Your review is already posted.");
			request.setAttribute("pageTitle", "Review posted");
			request.setAttribute("reviewObj", existingReview);
			request.getRequestDispatcher("frontend/review_info.jsp").forward(request, response);
				
		}
		else {
			request.setAttribute("pageTitle", "Write a review");
			request.getRequestDispatcher("frontend/review_form.jsp").forward(request, response);
			
		}
		
		
	}

	public void submitReview() throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String headline = request.getParameter("review_headline");
		String comment = request.getParameter("review_comment");
		
		Review newReview = new Review();
		newReview.setHeadline(headline);
		newReview.setComment(comment);
		newReview.setRating(rating);
		
		Book book = new Book();
		book.setBook_id(bookId);
		newReview.setBook(book);
		
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		newReview.setCustomer(customer);
		
		reviewDAO.create(newReview);
		request.setAttribute("message", "Your review is posted. Thank You!");
		request.setAttribute("pageTitle", "Review posted");
		request.getRequestDispatcher("frontend/review_done.jsp").forward(request, response);
				
	}
	
	
}
