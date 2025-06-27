package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Review;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	
}
