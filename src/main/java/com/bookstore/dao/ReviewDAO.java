package com.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
	
	
	@Override
	public Review create(Review review) {
		review.setReview_time(new Date());
		return super.create(review);
	}

	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
		
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("review.countAll");
	}
	
	public Review findByCustomerAndBook(int customerId, int bookId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("customerId", customerId);
		parameters.put("bookId", bookId);
		
		List<Review> listReview = super.findWithNamedQuery("review.findByCustomerAndBook", parameters);
		
		if(!listReview.isEmpty()) {
			return listReview.get(0);
		}
		return null;
		
	}
	
	public List<Review> listMostRecentReviews() {
		return super.findWithNamedQuery("review.listAll", 0, 3);
	}

}







