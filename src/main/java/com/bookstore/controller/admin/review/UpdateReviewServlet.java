package com.bookstore.controller.admin.review;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.bookstore.service.ReviewServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/update_review")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateReviewServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServices reviewServices = new ReviewServices(request, response);
		reviewServices.updateReview();
	}

}
